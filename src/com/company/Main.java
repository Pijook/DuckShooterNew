package com.company;

import com.company.game.GameTime;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
        try{
            Assets.load();
            Controllers.create();
            Controllers.getLeaderboardController().load();
        } catch (IOException | ClassNotFoundException | FontFormatException | UnsupportedAudioFileException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error while loading", JOptionPane.ERROR_MESSAGE);
        }

        gameTime = new GameTime();
    }

    public static void save(){

        try {
            Controllers.getLeaderboardController().save();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error while loading", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static GameFrame getGameFrame() {
        return gameFrame;
    }

    public static GameTime getGameTime() {
        return gameTime;
    }

    public static void setGameFrame(GameFrame gameFrame) {
        Main.gameFrame = gameFrame;
    }

    public static void setGameTime(GameTime gameTime) {
        Main.gameTime = gameTime;
    }
}
