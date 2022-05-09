package com.company.game;

import com.company.Assets;
import com.company.Controllers;
import com.company.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePane extends JPanel {

    private final GameController gameController;

    private final JLabel timerLabel;
    private final JLabel livesLabel;
    private final JLabel scoreLabel;

    private final JPanel shootingPane;

    private final JButton ammoButton;
    private final JButton upgradeAmmoButton;
    private final JButton upgradeDamageButton;

    public GamePane(){
        gameController = Controllers.getGameController();

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.ipady = 60;

        timerLabel = new JLabel("Time");
        timerLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        timerLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(timerLabel, gridBagConstraints);

        livesLabel = new JLabel("Lives");
        livesLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        livesLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        gridBagConstraints.gridx = 1;
        add(livesLabel, gridBagConstraints);

        scoreLabel = new JLabel("Score");
        scoreLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
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

        upgradeAmmoButton = new JButton("<html><center>Upgrade reload time!<br>(" + Settings.ammoUpgradeCost + ")</center></html>");
        upgradeAmmoButton.setFont(Assets.rainyHeartsFont.deriveFont(24f));

        upgradeAmmoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameController.getScore() >= Settings.ammoUpgradeCost){
                    gameController.setAmmoUpgrade(gameController.getAmmoUpgrade() + 1);
                    gameController.setScore(gameController.getScore() - Settings.ammoUpgradeCost);
                }
            }
        });

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(upgradeAmmoButton, gridBagConstraints);

        ammoButton = new JButton("Ammo: " + Controllers.getGameController().getAmmo());
        ammoButton.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        ammoButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        ammoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setAmmo((Settings.baseAmmo + Controllers.getGameController().getAmmoUpgrade()));
            }
        });

        gridBagConstraints.gridx = 1;
        add(ammoButton, gridBagConstraints);

        upgradeDamageButton = new JButton("<html><center>Upgrade damage!<br>(" + Settings.damageUpgradeCost + ")</center></html>");
        upgradeDamageButton.setFont(Assets.rainyHeartsFont.deriveFont(24f));
        upgradeDamageButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        upgradeDamageButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gameController.getScore() >= Settings.damageUpgradeCost){
                    gameController.setDamageUpgrade(gameController.getDamageUpgrade() + 1);
                    gameController.setScore(gameController.getScore() - Settings.damageUpgradeCost);
                }
            }
        });

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

    public JPanel getShootingPane() {
        return shootingPane;
    }

    public JButton getUpgradeAmmoButton() {
        return upgradeAmmoButton;
    }

    public JButton getUpgradeDamageButton() {
        return upgradeDamageButton;
    }

    public JButton getAmmoButton() {
        return ammoButton;
    }

}
