package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CustomCardLayout extends CardLayout {

    private Frame currentFrame;

    public CustomCardLayout(Frame currentFrame){
        this.currentFrame = currentFrame;
    }

    @Override
    public void show(Container parent, String name) {
        if(name.equalsIgnoreCase(Frame.GAME.name())){
            try {
                Controllers.getGameController().setGameActive(true);
            } catch (LineUnavailableException | IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        currentFrame = Frame.valueOf(name);
        super.show(parent, name);
    }
}
