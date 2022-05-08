package com.company.game;

import com.company.Main;
import com.company.Settings;
import com.company.duck.Duck;

import javax.swing.*;
import java.util.Iterator;

public class GameLoop extends Thread {

    private final GameController gameController;

    public GameLoop(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted() && gameController.isGameActive()){
            //System.out.println("Ducks alive " + gameController.getSpawnedDucks().size());
            Iterator<Duck> iterator = gameController.getSpawnedDucks().iterator();
            while(iterator.hasNext()){
                Duck duck = iterator.next();

                if(!duck.isAlive()){
                    SwingUtilities.invokeLater(() -> {
                        Main.getGameFrame().getGamePane().getShootingPane().remove(duck);
                    });

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
