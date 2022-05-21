package com.company.actor.duck;

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

        int bound = Main.getGameFrame().getGamePane().getShootingPane().getHeight();
        int difference = Main.getGameFrame().getGamePane().getHeight() - Main.getGameFrame().getGamePane().getShootingPane().getHeight();
        difference = difference/2;

        Position position;
        if(isLeft){
            position = new Position(
                    Settings.width,
                    random.nextInt(bound) - difference
            );
        }
        else{
            position = new Position(
                    0,
                    random.nextInt(bound) - difference
            );
        }

        ImageIcon imageIcon;
        if(isLeft){
            imageIcon = Assets.animatedDuckLeft;
        }
        else{
            imageIcon = Assets.animatedDuckRight;
        }

        Duck duck;
        if(chance <= 5){
            duck = new HardDuck(position, isLeft, imageIcon);
        }
        else if(chance <= 35){
            duck = new MediumDuck(position, isLeft, imageIcon);
        }
        else{
            duck = new EasyDuck(position, isLeft, imageIcon);
        }

        return duck;
    }

    private int lives;
    private final int score;
    private final int damage;
    private boolean alive;

    public Duck(int lives, int score, int damage, int speed, Position position, boolean left, ImageIcon imageIcon) {
        super(imageIcon, position, left, speed);
        this.lives = lives;
        this.score = score;
        this.damage = damage;
        this.alive = true;

        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        addActionListener(new DuckAction(this));
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
