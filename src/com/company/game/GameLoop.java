package com.company.game;

import com.company.Main;
import com.company.Settings;
import com.company.duck.Duck;

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
        while(!isInterrupted() && gameController.isGameActive()){
            Iterator<Duck> iterator = gameController.getSpawnedDucks().iterator();

            List<Duck> toRemove = new ArrayList<>();

            while(iterator.hasNext()){
                Duck duck = iterator.next();

                if(!duck.isAlive()){
                    toRemove.add(duck);
                    iterator.remove();
                    continue;
                }

                duck.act();

                if(duck.isLeft()){
                    if(duck.getPosition().getX() < -150){
                        gameController.setLives(gameController.getLives() - 1);
                        duck.setAlive(false);
                    }
                }
                else{
                    if(duck.getPosition().getX() > Settings.width){
                        gameController.setLives(gameController.getLives() - 1);
                        duck.setAlive(false);
                    }
                }
            }

            for(Duck duck : toRemove){
                SwingUtilities.invokeLater(() -> {
                    Main.getGameFrame().getGamePane().getShootingPane().remove(duck);
                });
            }

            SwingUtilities.invokeLater(() -> {
                Main.getGameFrame().getGamePane().getShootingPane().updateUI();
            });

            try {
                sleep(1000 / Settings.fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public GameController getGameController() {
        return gameController;
    }
}
