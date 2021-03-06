package com.company.game.difficulty;

import com.company.Assets;
import com.company.Controllers;
import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DifficultyPane extends JPanel {

    private JLabel titleLabel;
    private JButton easyModeButton;
    private JButton normalModeButton;
    private JButton doomModeButton;
    private JButton returnButton;

    public DifficultyPane(){
        createElements();
        createLayout();
    }

    private void createElements(){

        /*
            Title label
         */
        titleLabel = new JLabel("Choose difficulty!");
        titleLabel.setFont(Assets.rainyHeartsFont.deriveFont(72f));

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
        doomModeButton.setForeground(Color.RED);

        doomModeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setDifficulty(Difficulty.DOOM);
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.GAME.name());
            }
        });

        returnButton = new DifficultyButton("Return");
        returnButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.MAIN_MENU.name());
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

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);

        /*
            Easy button
         */
        gridBagConstraints.insets = new Insets(5,0,0,0);
        gridBagConstraints.ipady = 35;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(easyModeButton,gridBagConstraints);

        /*
            Normal button
         */
        gridBagConstraints.gridy = 2;
        add(normalModeButton,gridBagConstraints);

        /*
            Doom button
         */
        gridBagConstraints.gridy = 3;
        add(doomModeButton,gridBagConstraints);

        /*
            Return button
         */
        gridBagConstraints.gridy = 4;
        add(returnButton, gridBagConstraints);
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
}
