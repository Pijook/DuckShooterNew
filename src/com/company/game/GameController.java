package com.company.game;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;
import com.company.duck.Duck;

import java.util.ArrayList;
import java.util.Iterator;

public class GameController {

    private final ArrayList<Duck> spawnedDucks;

    private final GameLoop gameLoop;

    private int time;
    private int lives;
    private int score;
    private boolean gameActive;

    public GameController(){
        spawnedDucks = new ArrayList<>();
        gameLoop = new GameLoop(this);
    }

    public void reset(){
        System.out.println("Resseting!");
        time = 0;
        lives = Settings.lives;
        score = 0;
        setGameActive(true);
    }

    public void spawnDuck(){
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
        System.out.println(this.time);
        Main.getGameFrame().getGamePane().getTimerLabel().setText("Time: " + this.time);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
        Main.getGameFrame().getGamePane().getLivesLabel().setText("Lives: " + this.lives);
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

    public ArrayList<Duck> getSpawnedDucks() {
        return spawnedDucks;
    }
}
