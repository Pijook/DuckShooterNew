package com.company.duck;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;
import com.company.Assets;

import javax.swing.*;
import java.util.Random;

public abstract class Duck extends JButton {

    public static Duck spawnNewDuck(){
        Random random = new Random();
        int chance = random.nextInt(100);

        Duck duck;
        if(chance <= 5){
            duck = new HardDuck();
        }
        else if(chance <= 35){
            duck = new MediumDuck();
        }
        else{
            duck = new EasyDuck();
        }

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

        duck.setPosition(position);
        duck.setLeft(isLeft);
        return duck;
    }

    private int lives;
    private final int score;
    private final int damage;
    private final int speed;
    private boolean alive;

    private Position position;
    private boolean left;

    public Duck(int lives, int score, int damage, int speed) {
        //super(Assets.animatedDuckBigImage);
        super(new ImageIcon(Assets.duckTestImage));

        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        this.lives = lives;
        this.score = score;
        this.damage = damage;
        this.speed = speed;
        this.alive = true;
        setText("Hits " + lives);
        addActionListener(new DuckAction(this));
    }

    public void act(){
        if(isLeft()){
            position.move(-speed, 0);
        }
        else{
            position.move(speed, 0);
        }

        setBounds(position.getX(), position.getY(), 100, 150);
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpeed() {
        return speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
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
