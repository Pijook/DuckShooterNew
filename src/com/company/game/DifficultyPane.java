package com.company.game;

import com.company.Assets;
import com.company.Controllers;
import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DifficultyPane extends JPanel {

    public DifficultyPane(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 50;

        gridBagConstraints.insets = new Insets(20,0,0,0);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        JButton easyModeButton = new JButton("Easy");
        easyModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f));

        easyModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.EASY);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        add(easyModeButton, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        JButton normalModeButton = new JButton("Normal");
        normalModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f));

        normalModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.NORMAL);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        add(normalModeButton, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        JButton doomModeButton = new JButton("DOOM");
        doomModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f).deriveFont(Font.BOLD));
        doomModeButton.setForeground(Color.RED);

        doomModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.DOOM);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        add(doomModeButton, gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();//.getScaledInstance(1280, 720,Image.SCALE_DEFAULT);
        g.drawImage(image, 0,0,this);
    }

}
