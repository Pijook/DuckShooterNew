package com.company.game;

import com.company.*;
import com.company.actor.MovingActor;
import com.company.actor.duck.Duck;
import com.company.actor.obstacles.Cloud;
import com.company.game.difficulty.Difficulty;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GameController {

    private final ArrayList<MovingActor> spawnedActors;

    private GameLoop gameLoop;

    private Clip musicClip;

    /*private int spawnRate;
    private int tempRate;
    private int decreaseRate;*/

    private SpawnRate duckSpawnRate;
    private SpawnRate obstacleSpawnRate;

    private int ammoUpgrade;
    private int damageUpgrade;

    private int ammo;
    private int damage;
    private int time;
    private int lives;
    private int score;
    private boolean gameActive;

    public GameController() throws LineUnavailableException, IOException {
        spawnedActors = new ArrayList<>();
        gameLoop = new GameLoop(this);

        ammoUpgrade = 0;
        damageUpgrade = 0;

        musicClip = AudioSystem.getClip();
        musicClip.open(Assets.peacefulDuckSong);
    }

    public void reset() {
        time = 0;
        lives = Settings.lives;
        score = 0;
        damage = Settings.baseDamage;
        ammo = Settings.baseAmmo;
        musicClip.setFramePosition(0);

        SwingUtilities.invokeLater(() -> {
            Iterator<MovingActor> iterator = spawnedActors.iterator();
            while(iterator.hasNext()){
                MovingActor actor = iterator.next();
                Main.getGameFrame().getGamePane().getShootingPane().remove(actor);
                iterator.remove();
            }
        });
    }

    public void setDifficulty(Difficulty difficulty){
        switch (difficulty){
            case EASY -> {
                duckSpawnRate = new SpawnRate(200, 180, 2);
                obstacleSpawnRate = new SpawnRate(200, 180, 0);
            }
            case NORMAL -> {
                duckSpawnRate = new SpawnRate(150, 120, 3);
                obstacleSpawnRate = new SpawnRate(150, 120, 0);
            }
            case DOOM -> {
                duckSpawnRate = new SpawnRate(100, 90, 10);
                obstacleSpawnRate = new SpawnRate(100, 90, 0);
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
        spawnedActors.add(duck);
        Main.getGameFrame().getGamePane().getShootingPane().add(duck);
    }

    public void spawnCloud(){
        Cloud cloud = Cloud.spawnCloud();
        spawnedActors.add(cloud);
        Main.getGameFrame().getGamePane().getObstaclePane().add(cloud);
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
        if(gameActive){
            reset();

            if(gameLoop.isInterrupted() || !gameLoop.isAlive()){
                gameLoop = new GameLoop(this);
            }
            gameLoop.start();

            musicClip.start();
            setValuesOnScreen();

            if(Main.getGameTime().isInterrupted() || !Main.getGameTime().isAlive()){
                Main.setGameTime(new GameTime());
            }
            Main.getGameTime().start();
        }
        else{
            if(!gameLoop.isInterrupted()){
                gameLoop.interrupt();
            }
            if(!Main.getGameTime().isInterrupted()){
                Main.getGameTime().interrupt();
            }
            musicClip.stop();
        }
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public synchronized ArrayList<MovingActor> getSpawnedActors() {
        return spawnedActors;
    }

    public int getDamageUpgrade() {
        return damageUpgrade;
    }

    public void setDamageUpgrade(int damageUpgrade) {
        this.damageUpgrade = damageUpgrade;
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
