package com.company.actor;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;

import javax.swing.*;

public abstract class MovingActor extends JButton {

    private Position position;
    private final boolean left;
    private final int speed;
    private boolean alive;
    private ImageIcon imageIcon;
    private String layer;

    private final Thread thread;

    public MovingActor(ImageIcon imageIcon, Position position, boolean left, int speed){
        super(imageIcon);
        //super(new ImageIcon(imageIcon.getImage()));
        this.imageIcon = imageIcon;
        this.position = position;
        this.left = left;
        this.speed = speed;
        this.alive = true;

        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);

        thread = new Thread(() -> {
            while(!Thread.interrupted() && Controllers.getGameController().isGameActive()){
                try{
                    Thread.sleep(1000 / Settings.speed);
                    act();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }

            Main.getGameFrame().getGamePane().getShootingLayers().get(layer).remove(this);
        });
        thread.start();
    }

    public void act(){
        if(isLeft()){
            position.move(-speed, 0);
            if(getPosition().getX() < -getImageIcon().getIconWidth()){
                setAlive(false);
            }
        }
        else{
            position.move(speed, 0);
            if(getPosition().getX() > Settings.currentResolution.getWidth()){
                setAlive(false);
            }
        }

        if(!alive){
            thread.interrupt();
        }

        setBounds(position.getX(), position.getY(), imageIcon.getIconWidth(), imageIcon.getIconHeight());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public boolean isLeft() {
        return left;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "MovingActor{" +
                "position=" + position +
                ", left=" + left +
                ", speed=" + speed +
                ", alive=" + alive +
                ", imageIcon=" + imageIcon +
                "} " + super.toString();
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }
}
