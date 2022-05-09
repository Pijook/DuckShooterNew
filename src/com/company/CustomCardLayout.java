package com.company;

import java.awt.*;

public class CustomCardLayout extends CardLayout {

    private Frame currentFrame;

    public CustomCardLayout(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    @Override
    public void show(Container parent, String name) {
        if(currentFrame.equals(Frame.GAME)){
            System.out.println("Interupting");
            Main.getGameTime().interrupt();
        }
        else if(name.equalsIgnoreCase(Frame.GAME.name())){
            Controllers.getGameController().reset();
            Controllers.getGameController().setGameActive(true);
            Controllers.getGameController().setValuesOnScreen();
            Main.getGameTime().start();
        }
        currentFrame = Frame.valueOf(name);
        super.show(parent, name);
    }
}
