package com.company.game;

import com.company.Assets;
import com.company.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePane extends JPanel {

    private JLabel timerLabel;
    private JLabel livesLabel;
    private JLabel scoreLabel;
    private JLabel ammoLabel;

    private JPanel shootingPane;

    private JButton upgradeReloadTimeButton;
    private JButton upgradeDamageButton;

    public GamePane(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.ipady = 60;

        timerLabel = new JLabel("Time");
        timerLabel.setFont(Assets.rainyHeartsFont.deriveFont(16f));
        timerLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(timerLabel, gridBagConstraints);

        livesLabel = new JLabel("Lives");
        livesLabel.setFont(Assets.rainyHeartsFont.deriveFont(16f));
        livesLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.gridx = 1;
        add(livesLabel, gridBagConstraints);

        scoreLabel = new JLabel("Score");
        scoreLabel.setFont(Assets.rainyHeartsFont.deriveFont(16f));
        scoreLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.gridx = 2;
        add(scoreLabel, gridBagConstraints);

        shootingPane = new JPanel();
        shootingPane.setLayout(null);
        shootingPane.setBackground(Color.ORANGE);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 600;
        add(shootingPane, gridBagConstraints);

        gridBagConstraints.ipady = 60;

        upgradeReloadTimeButton = new JButton("Upgrade reload time!");

        upgradeReloadTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().spawnDuck();
            }
        });

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(upgradeReloadTimeButton, gridBagConstraints);



        ammoLabel = new JLabel("Ammo");
        ammoLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.gridx = 1;
        add(ammoLabel, gridBagConstraints);

        upgradeDamageButton = new JButton("Upgrade damage!");
        gridBagConstraints.gridx = 2;
        add(upgradeDamageButton, gridBagConstraints);
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public JLabel getLivesLabel() {
        return livesLabel;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getAmmoLabel() {
        return ammoLabel;
    }

    public JPanel getShootingPane() {
        return shootingPane;
    }

    public JButton getUpgradeReloadTimeButton() {
        return upgradeReloadTimeButton;
    }

    public JButton getUpgradeDamageButton() {
        return upgradeDamageButton;
    }
}
