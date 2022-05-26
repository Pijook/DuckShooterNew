package com.company.menu;

import com.company.Assets;
import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPane extends JPanel {

    private JButton startButton;
    private JButton leaderBoardButton;
    private JButton optionButton;
    private JButton exitButton;

    private JPanel actorsPane;

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
        startButton = new MenuButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.DIFFICULTY.name());
            }
        });

        /*
            Exit button
         */
        exitButton = new MenuButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.save();
                System.exit(0);
            }
        });

        /*
            Leaderboard button
         */
        leaderBoardButton = new MenuButton("Leaderboard");
        leaderBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.LEADERBOARD.name());
            }
        });

        /*
        Option button
         */
        optionButton = new MenuButton("Option");
        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.OPTIONS.name());
            }
        });

        /*
            Actors pane
         */
        actorsPane = new JPanel();
        actorsPane.setBorder(BorderFactory.createLineBorder(Color.RED));


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
        gridBagConstraints.insets = new Insets(5,0,0,0);
        gridBagConstraints.ipady = 35;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(startButton, gridBagConstraints);

        /*
            Leaderboard button
         */
        gridBagConstraints.gridy = 2;
        add(leaderBoardButton, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        add(optionButton, gridBagConstraints);

        /*
            Exit button
         */
        gridBagConstraints.gridy = 4;
        add(exitButton, gridBagConstraints);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();
        g.drawImage(image, 0,0,this);
        g.drawImage(image, Assets.backgroundImage.getIconWidth(), 0, this);
        g.drawImage(image, 0, Assets.backgroundImage.getIconHeight(), this);
        g.drawImage(image, Assets.backgroundImage.getIconWidth(), Assets.backgroundImage.getIconHeight(), this);
    }

    public JPanel getActorsPane() {
        return actorsPane;
    }

    public JButton getOptionButton() {
        return optionButton;
    }
}
