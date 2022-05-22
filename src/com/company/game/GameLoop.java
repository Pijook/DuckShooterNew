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
            Iterator<MovingActor> iterator = gameController.getSpawnedActors().iterator();

            List<MovingActor> toRemove = new ArrayList<>();

            while(iterator.hasNext()){
                MovingActor actor = iterator.next();

                actor.act();

                if(!actor.isAlive()){
                    toRemove.add(actor);
                    iterator.remove();
                    continue;
                }

                if(actor.isLeft()){
                    if(actor.getPosition().getX() < -actor.getImageIcon().getIconWidth()){
                        actor.setAlive(false);
                    }
                }
                else{
                    if(actor.getPosition().getX() > Settings.width){
                        actor.setAlive(false);
                    }
                }

                if(!actor.isAlive()){
                    if(actor instanceof Duck duck){
                        gameController.setLives(gameController.getLives() - duck.getDamage());
                    }
                }
            }

            for(MovingActor movingActor : toRemove){
                SwingUtilities.invokeLater(() -> {
                    /*if(movingActor instanceof Duck){
                        Main.getGameFrame().getGamePane().getShootingPane().remove(movingActor);
                    }
                    else if(movingActor instanceof Tree){
                        System.out.println("Removing trreeeee!");
                    }
                    else{
                        Main.getGameFrame().getGamePane().getObstaclePane().remove(movingActor);
                    }*/
                    Main.getGameFrame().getGamePane().getShootingLayers().get(movingActor.getLayer()).remove(movingActor);
                });
            }

            SwingUtilities.invokeLater(() -> {
                /*Main.getGameFrame().getGamePane().getShootingPane().updateUI();
                Main.getGameFrame().getGamePane().getObstaclePane().updateUI();*/
                for(JPanel jPanel : Main.getGameFrame().getGamePane().getShootingLayers().values()){
                    jPanel.updateUI();
                }
            });

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
                sleep(1000 / Settings.fps);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public GameController getGameController() {
        return gameController;
    }
}
