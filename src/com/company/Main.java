package com.company;

import com.company.game.GameTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {

    private static GameFrame gameFrame;
    private static GameTime gameTime;

    public static void main(String[] args) {

        load();

        SwingUtilities.invokeLater(() -> {

            gameFrame = new GameFrame();

            gameFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    save();
                    super.windowClosing(e);
                }
            });

        });

    }

    private static void load(){
        Controllers.create();

        try{
            Controllers.getLeaderboardController().load();
            Assets.load();
        } catch (IOException | ClassNotFoundException | FontFormatException e) {
            e.printStackTrace();
        }


        gameTime = new GameTime();
    }

    public static void save(){

        try {
            Controllers.getLeaderboardController().save();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static GameFrame getGameFrame() {
        return gameFrame;
    }

    public static GameTime getGameTime() {
        return gameTime;
    }
}
