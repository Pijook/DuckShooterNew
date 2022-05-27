package com.company.game;

import com.company.*;
import com.company.actor.Position;
import com.company.actor.duck.Duck;
import com.company.actor.obstacles.Cloud;
import com.company.actor.obstacles.Tree;
import com.company.game.difficulty.Difficulty;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {

    private GameLoop gameLoop;

    private final Clip musicClip;
    private final FloatControl volumeControl;

    //Difficulty
    private SpawnRate duckSpawnRate;
    private SpawnRate obstacleSpawnRate;
    private int treesToSpawn;

    private final Position[] treePossibleSpawn;

    private int ammoUpgrade;
    private int damageUpgrade;

    private int ammo;
    private int damage;
    private int time;
    private int lives;
    private int score;
    private boolean gameActive;

    public GameController() throws LineUnavailableException, IOException {
        gameLoop = new GameLoop(this);

        ammoUpgrade = 0;
        damageUpgrade = 0;

        musicClip = AudioSystem.getClip();
        musicClip.open(Assets.peacefulDuckSong);
        volumeControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);

        treePossibleSpawn = new Position[]{
                new Position(250, 100),
                new Position(100, 250),
                new Position(600, 300),
                new Position(800, 100),
                new Position(50, 50),
                new Position(800, 100),
                new Position(900, 250),
                new Position(1000, 300),
        };
    }

    public void reset() {
        time = 0;
        lives = Settings.getLives();
        score = 0;
        damage = Settings.getBaseDamage();
        ammo = Settings.getBaseAmmo();
        ammoUpgrade = 0;
        damageUpgrade = 0;
        musicClip.setFramePosition(0);
    }

    public void setDifficulty(Difficulty difficulty){
        switch (difficulty){
            case EASY -> {
                duckSpawnRate = new SpawnRate(200, 180, 2);
                obstacleSpawnRate = new SpawnRate(200, 180, 0);
                treesToSpawn = 1;
            }
            case NORMAL -> {
                duckSpawnRate = new SpawnRate(150, 120, 3);
                obstacleSpawnRate = new SpawnRate(150, 120, 0);
                treesToSpawn = 2;
            }
            case DOOM -> {
                duckSpawnRate = new SpawnRate(100, 90, 10);
                obstacleSpawnRate = new SpawnRate(100, 90, 0);
                treesToSpawn = 3;
            }
        }
    }

    public void end(){
        try {
            setGameActive(false);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

        String nickname = null;

        while(nickname == null || nickname.length() == 0 || nickname.length() > 32) {
            nickname = JOptionPane.showInputDialog(Main.getGameFrame(), "Enter your nickname");
        }

        Controllers.getLeaderboardController().add(nickname, score, ammoUpgrade, damageUpgrade, time);

        Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.LEADERBOARD.name());
    }

    public void spawnDuck(){
        Duck duck = Duck.spawnNewDuck();
        Main.getGameFrame().getGamePane().getShootingLayers().get(duck.getLayer()).add(duck);
    }

    public void spawnCloud(){
        Cloud cloud = Cloud.spawnCloud();
        Main.getGameFrame().getGamePane().getShootingLayers().get(cloud.getLayer()).add(cloud);
    }

    public void spawnTrees(){
        Random random = new Random();
        List<Integer> lockedSpawns = new ArrayList<>();

        for(int i = 0; i < treesToSpawn; i++){
            int spawnIndex = -1;
            while(spawnIndex == -1 || lockedSpawns.contains(spawnIndex)){
                spawnIndex = random.nextInt(treePossibleSpawn.length);
            }
            Tree tree = new Tree(treePossibleSpawn[spawnIndex]);

            Main.getGameFrame().getGamePane().getShootingLayers().get(tree.getLayer()).add(tree);

            lockedSpawns.add(spawnIndex);
        }
    }

    public void setValuesOnScreen(){
        setTime(time);
        setLives(lives);
        setScore(score);
        setAmmo(ammo);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
        Main.getGameFrame().getGamePane().getTimerLabel().setText("Time: " + this.time);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        Main.getGameFrame().getGamePane().getLivesLabel().setText("Lives: " + this.lives);
        if(lives <= 0){
            end();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        Main.getGameFrame().getGamePane().getScoreLabel().setText("Score: " + this.score);
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
        Main.getGameFrame().getGamePane().getAmmoButton().setText("Ammo: " + this.ammo);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public void setGameActive(boolean gameActive) throws LineUnavailableException, IOException {
        this.gameActive = gameActive;
        if (gameActive) {
            reset();

            if (gameLoop.isInterrupted() || !gameLoop.isAlive()) {
                gameLoop = new GameLoop(this);
            }

            gameLoop.start();

                /*
                    From percent to decibel
                 */
            float range = volumeControl.getMinimum();
            float result = range * (1 - Settings.getVolumeLevel() / 100.0f);
            volumeControl.setValue(result);
            musicClip.start();

            setValuesOnScreen();

            if (Main.getGameTime().isInterrupted() || !Main.getGameTime().isAlive()) {
                Main.setGameTime(new GameTime());
            }

            Main.getGameTime().start();
        } else {
            if (!gameLoop.isInterrupted()) {
                gameLoop.interrupt();
            }
            if (!Main.getGameTime().isInterrupted()) {
                Main.getGameTime().interrupt();
            }
            musicClip.stop();
        }

    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public int getDamageUpgrade() {
        return damageUpgrade;
    }

    public void setDamageUpgrade(int damageUpgrade) {
        this.damageUpgrade = damageUpgrade;
        Main.getGameFrame().getGamePane().getUpgradeDamageButton().setText("<html><center>Upgrade damage!<br>(" + Settings.getDamageUpgradeCost() + ")<br>Current: " + this.damageUpgrade + "</center></html>");
    }

    public int getAmmoUpgrade() {
        return ammoUpgrade;
    }

    public void setAmmoUpgrade(int ammoUpgrade) {
        this.ammoUpgrade = ammoUpgrade;
    }

    public SpawnRate getDuckSpawnRate() {
        return duckSpawnRate;
    }

    public SpawnRate getObstacleSpawnRate() {
        return obstacleSpawnRate;
    }
}
