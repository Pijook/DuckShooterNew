package com.company.menu;

import com.company.Main;
import com.company.Settings;
import com.company.actor.MovingActor;
import com.company.actor.duck.Duck;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuLoop extends Thread {

    private final List<MovingActor> ducks;
    private boolean menuActive;

    public MenuLoop(){
        ducks = new ArrayList<>();
        menuActive = true;
    }

    @Override
    public void run() {
        super.run();

        while(!isInterrupted()){
            Iterator<MovingActor> iterator = ducks.iterator();

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

            }

            for(MovingActor movingActor : toRemove){
                SwingUtilities.invokeLater(() -> {
                    if(movingActor instanceof Duck){
                        Main.getGameFrame().getGamePane().getShootingPane().remove(movingActor);
                    }
                    else{
                        Main.getGameFrame().getGamePane().getObstaclePane().remove(movingActor);
                    }
                });
            }

            SwingUtilities.invokeLater(() -> {
                Main.getGameFrame().getGamePane().getShootingPane().updateUI();
                Main.getGameFrame().getGamePane().getObstaclePane().updateUI();
            });


            try{
                sleep(1000 / Settings.fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
