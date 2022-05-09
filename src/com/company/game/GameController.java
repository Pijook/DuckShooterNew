package com.company.game;

import com.company.Controllers;
import com.company.Frame;
import com.company.Main;
import com.company.Settings;
import com.company.duck.Duck;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameController {

    private final ArrayList<Duck> spawnedDucks;

    private final GameLoop gameLoop;

    private int spawnRate;
    private int tempRate;

    private int reloadUpgrade;
    private int damageUpgrade;

    private int time;
    private int lives;
    private int score;
    private boolean gameActive;

    public GameController(){
        spawnedDucks = new ArrayList<>();
        gameLoop = new GameLoop(this);
    }

    public void reset(){
        time = 0;
        lives = Settings.lives;
        score = 0;

        spawnRate = 150;
        tempRate = 0;
    }

    public void end(){
        setGameActive(false);

        String nickname = JOptionPane.showInputDialog(Main.getGameFrame(), "Enter your nickname");

        Controllers.getLeaderboardController().add(nickname, score, reloadUpgrade, damageUpgrade, time);

        Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.MAIN_MENU.name());
    }

    public void spawnDuck(){
        System.out.println("Spawning duck");
        Duck duck = Duck.spawnNewDuck();
        spawnedDucks.add(duck);
        Main.getGameFrame().getGamePane().getShootingPane().add(duck);
    }

    public void setValuesOnScreen(){
        setTime(time);
        setLives(lives);
        setScore(score);
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

    public boolean isGameActive() {
        return gameActive;
    }

    public void setGameActive(boolean gameActive) {
        this.gameActive = gameActive;
        if(gameActive){
            if(gameLoop.isInterrupted() || !gameLoop.isAlive()){
                gameLoop.start();
            }
        }
        else{
            if(!gameLoop.isInterrupted()){
                gameLoop.interrupt();
            }
        }
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public int getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public int getTempRate() {
        return tempRate;
    }

    public void setTempRate(int tempRate) {
        this.tempRate = tempRate;
    }

    public synchronized ArrayList<Duck> getSpawnedDucks() {
        return spawnedDucks;
    }
}
