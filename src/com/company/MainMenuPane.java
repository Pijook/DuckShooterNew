package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainMenuPane extends JPanel {

    private JButton startButton;
    private JButton leaderBoardButton;
    private JButton exitButton;

    private JLabel titleLabel;

    public MainMenuPane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        /*
            Title label
         */
        titleLabel = new JLabel("Duck Shooter!");
        titleLabel.setFont(Assets.rainyHeartsFont.deriveFont(72f));

        /*
            Start button
         */
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.DIFFICULTY.name());
            }
        });

        /*
            Exit button
         */
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.save();
                System.exit(0);
                //Main.getGameFrame().dispose();
            }
        });

        /*
            Leaderboard button
         */
        leaderBoardButton = new JButton("Leaderboard");
        leaderBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.LEADERBOARD.name());
            }
        });
    }

    private void createLayout(){
        setLayout(new GridBagLayout());

        /*
            Overall settings
         */
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        /*
            Title label
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);

        /*
            Start button
         */
        gridBagConstraints.insets = new Insets(35,0,0,0);
        gridBagConstraints.ipady = 35;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(startButton, gridBagConstraints);

        /*
            Leaderboard button
         */
        gridBagConstraints.gridy = 2;
        add(leaderBoardButton, gridBagConstraints);

        /*
            Exit button
         */
        gridBagConstraints.gridy = 3;
        add(exitButton, gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();
        g.drawImage(image, 0,0,this);
    }
}
