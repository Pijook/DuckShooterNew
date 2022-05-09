package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainMenuPane extends JPanel {

    public MainMenuPane(){
        JButton startButton = new JButton("Start");
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Duck Shooter!");
        titleLabel.setFont(Assets.rainyHeartsFont.deriveFont(72f));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.DIFFICULTY.name());
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
                Main.save();
                System.exit(0);
                //Main.getGameFrame().dispose();
            }
        });


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(titleLabel, gridBagConstraints);

        gridBagConstraints.insets = new Insets(35,0,0,0);
        gridBagConstraints.ipady = 35;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(startButton, gridBagConstraints);

        gridBagConstraints.gridy = 2;

        add(leaderBoardButton, gridBagConstraints);

        gridBagConstraints.gridy = 3;

        add(exitButton, gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();//.getScaledInstance(1280, 720,Image.SCALE_DEFAULT);
        g.drawImage(image, 0,0,this);
    }
}
