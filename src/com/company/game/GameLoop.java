package com.company.game;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;
import com.company.actor.MovingActor;
import com.company.actor.duck.Duck;
import com.company.actor.obstacles.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameLoop extends Thread {

    private final GameController gameController;

    public GameLoop(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void run() {
        super.run();
        Controllers.getGameController().spawnTrees();
        while(!isInterrupted() && gameController.isGameActive()){
            if(gameController.getDuckSpawnRate().readyToSpawn()){
                gameController.spawnDuck();
                gameController.getDuckSpawnRate().resetSpawnRate();
            }

            if(gameController.getObstacleSpawnRate().readyToSpawn()){
                gameController.spawnCloud();
                gameController.getObstacleSpawnRate().resetSpawnRate();
            }

            gameController.getDuckSpawnRate().setTempRate(gameController.getDuckSpawnRate().getTempRate() + 1);
            gameController.getObstacleSpawnRate().setTempRate(gameController.getObstacleSpawnRate().getTempRate() + 1);

            try {
                sleep(1000 / Settings.speed);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public GameController getGameController() {
        return gameController;
    }
}
