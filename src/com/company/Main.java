package com.company;

import com.company.leaderboard.Controllers;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static GameFrame gameFrame;

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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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
}
