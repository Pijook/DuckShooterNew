package com.company.actor;

import javax.swing.*;

public abstract class MovingActor extends JButton {

    private Position position;
    private boolean left;
    private int speed;
    private boolean alive;
    private ImageIcon imageIcon;
    private String layer;

    public MovingActor(ImageIcon imageIcon, Position position, boolean left, int speed){
        super(new ImageIcon(imageIcon.getImage()));
        this.imageIcon = imageIcon;
        this.position = position;
        this.left = left;
        this.speed = speed;
        this.alive = true;

        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
    }

    public void act(){
        if(isLeft()){
            position.move(-speed, 0);
        }
        else{
            position.move(speed, 0);
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
