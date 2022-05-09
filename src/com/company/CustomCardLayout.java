package com.company;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.io.IOException;

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
            try {
                Controllers.getGameController().reset();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Controllers.getGameController().setGameActive(true);
            Controllers.getGameController().setValuesOnScreen();
            Main.getGameTime().start();
        }
        currentFrame = Frame.valueOf(name);
        super.show(parent, name);
    }
}
