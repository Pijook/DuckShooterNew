package com.company;

import com.company.game.GameTime;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static GameFrame gameFrame;
    private static GameTime gameTime;

    public static void main(String[] args) {

        load();

        SwingUtilities.invokeLater(() -> {

            gameFrame = new GameFrame();

        });

        save();

    }

    private static void load(){
        Controllers.create();

        try{
            Controllers.getLeaderboardController().load();
            Textures.load();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        gameTime = new GameTime();
    }

    private static void save(){

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