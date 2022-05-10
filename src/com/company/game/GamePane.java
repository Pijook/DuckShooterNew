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

    private JLabel timerLabel;
    private JLabel livesLabel;
    private JLabel scoreLabel;

    private JPanel shootingPane;
    private JPanel obstaclePane;

    private JButton ammoButton;
    private JButton upgradeAmmoButton;
    private JButton upgradeDamageButton;

    public GamePane(){
        gameController = Controllers.getGameController();

        createElements();
        createLayout();
    }

    private void createElements(){
        /*
            Timer label
         */
        timerLabel = new JLabel("Time");
        timerLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        timerLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        timerLabel.setOpaque(false);

        /*
            Lives label
         */
        livesLabel = new JLabel("Lives");
        livesLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        livesLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        livesLabel.setOpaque(false);

        /*
            Score label
         */
        scoreLabel = new JLabel("Score");
        scoreLabel.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        scoreLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        scoreLabel.setOpaque(false);

        /*
            Shooting pane
         */
        shootingPane = new JPanel();
        shootingPane.setLayout(null);
        shootingPane.setOpaque(false);

        /*
            Obstacle pane
         */
        obstaclePane = new JPanel();
        obstaclePane.setLayout(null);
        obstaclePane.setOpaque(false);

        /*
            Ammo button
         */
        ammoButton = new JButton("Ammo: " + Controllers.getGameController().getAmmo());
        ammoButton.setFont(Assets.rainyHeartsFont.deriveFont(28f));
        ammoButton.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        ammoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controllers.getGameController().setAmmo((Settings.baseAmmo + Controllers.getGameController().getAmmoUpgrade()));
            }
        });

        /*
            Upgrade ammo button
         */
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

        /*
            Upgrade damage button
         */
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
    }

    private void createLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /*
            Overall settings
         */
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0.5;

        /*
            Timer label
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(timerLabel, gridBagConstraints);

        /*
            Lives label
         */
        gridBagConstraints.gridx = 1;
        add(livesLabel, gridBagConstraints);

        /*
            Score label
         */
        gridBagConstraints.gridx = 2;
        add(scoreLabel, gridBagConstraints);



        /*
            Obstacle pane
         */
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 600;
        add(obstaclePane, gridBagConstraints);

        /*
            Shooting pane
         */
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 600;
        add(shootingPane, gridBagConstraints);

        /*
            Upgrade ammo button
         */
        gridBagConstraints.ipady = 60;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(upgradeAmmoButton, gridBagConstraints);

        /*
            Ammo button
         */
        gridBagConstraints.gridx = 1;
        add(ammoButton, gridBagConstraints);

        /*
            Upgrade damage button
         */
        gridBagConstraints.gridx = 2;
        add(upgradeDamageButton, gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();//.getScaledInstance(1280, 720,Image.SCALE_DEFAULT);
        g.drawImage(image, 0,0,this);
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

    public JPanel getObstaclePane() {
        return obstaclePane;
    }
}
