package com.company.actor.duck;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;
import com.company.Assets;
import com.company.actor.MovingActor;
import com.company.actor.Position;

import javax.swing.*;
import java.util.Random;

public abstract class Duck extends MovingActor {

    public static Duck spawnNewDuck(){
        Random random = new Random();
        int chance = random.nextInt(100);

        boolean isLeft = random.nextBoolean();

        JPanel shootingPane = Main.getGameFrame().getGamePane().getShootingLayers().get("duckLayer");
        int range = shootingPane.getHeight() - Assets.easyDuckRight.getIconHeight();
        int moveBy = shootingPane.getX();

        Position position;
        if(isLeft){
            position = new Position(
                    Settings.currentResolution.getWidth(),
                    random.nextInt(range) + moveBy
            );
        }
        else{
            position = new Position(
                    0,
                    random.nextInt(range) + moveBy
            );
        }

        System.out.println("Generated y: " + position.getY());

        if(position.getY() >= Main.getGameFrame().getGamePane().getUpgradeAmmoButton().getY()){
            System.out.println("Error: " + position.getY());
        }

        Duck duck;
        if(chance <= 5){
            if(isLeft){
                duck = new HardDuck(position, isLeft, Assets.hardDuckLeft);
            }
            else{
                duck = new HardDuck(position, isLeft, Assets.hardDuckRight);
            }
        }
        else if(chance <= 35){
            if(isLeft){
                duck = new MediumDuck(position, isLeft, Assets.mediumDuckLeft);
            }
            else{
                duck = new MediumDuck(position, isLeft, Assets.mediumDuckRight);
            }
        }
        else{
            if(isLeft){
                duck = new EasyDuck(position, isLeft, Assets.easyDuckLeft);
            }
            else{
                duck = new EasyDuck(position, isLeft, Assets.easyDuckRight);
            }
        }

        return duck;
    }

    private int lives;
    private final int score;
    private final int damage;

    public Duck(int lives, int score, int damage, int speed, Position position, boolean left, ImageIcon imageIcon) {
        super(imageIcon, position, left, speed);
        this.lives = lives;
        this.score = score;
        this.damage = damage;

        addActionListener(new DuckAction(this));
        setLayer("duckLayer");
    }

    @Override
    public void act() {
        super.act();
        if(!isAlive()){
            if(isLeft()){
                if(getPosition().getX() < -getImageIcon().getIconWidth()){
                    System.out.println("taking live!");
                    Controllers.getGameController().setLives(Controllers.getGameController().getLives() - damage);
                }
            }
            else{
                if(getPosition().getX() > Settings.currentResolution.getWidth()){
                    System.out.println("taking live!");
                    Controllers.getGameController().setLives(Controllers.getGameController().getLives() - damage);
                }
            }
        }
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int getDamage() {
        return damage;
    }
}
