package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPane extends JPanel {

    public MainMenuPane(){
        JButton startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        JButton leaderBoardButton = new JButton("Leaderboard");

        leaderBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.LEADERBOARD.name());
            }
        });

        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(startButton);
        add(leaderBoardButton);
        add(exitButton);
    }

}
