package com.company.game.difficulty;

import com.company.Assets;
import com.company.Controllers;
import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DifficultyPane extends JPanel {

    private JButton easyModeButton;
    private JButton normalModeButton;
    private JButton doomModeButton;

    public DifficultyPane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        /*
            Easy button
         */
        easyModeButton = new DifficultyButton("Easy");
        //easyModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f));

        easyModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.EASY);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        /*
            Normal button
         */
        normalModeButton = new DifficultyButton("Normal");
        //normalModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f));

        normalModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.NORMAL);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        /*
            Doom button
         */
        doomModeButton = new DifficultyButton("DOOM");
        //doomModeButton.setFont(Assets.rainyHeartsFont.deriveFont(36f).deriveFont(Font.BOLD));
        doomModeButton.setForeground(Color.RED);

        doomModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.DOOM);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });
    }

    private void createLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /*
            Overall settings
         */
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.insets = new Insets(5,0,0,0);

        /*
            Easy button
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(easyModeButton,gridBagConstraints);

        /*
            Normal button
         */
        gridBagConstraints.gridy = 1;
        add(normalModeButton,gridBagConstraints);

        /*
            Doom button
         */
        gridBagConstraints.gridy = 2;
        add(doomModeButton,gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();//.getScaledInstance(1280, 720,Image.SCALE_DEFAULT);
        g.drawImage(image, 0,0,this);
    }

}
