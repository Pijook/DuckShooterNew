package com.company;

import com.company.game.GamePane;
import com.company.leaderboard.LeaderboardPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

    private CustomCardLayout cardLayout;

    //Panes
    private JPanel mainPane;
    private MainMenuPane mainMenuPane;
    private LeaderboardPane leaderboardPane;
    private GamePane gamePane;

    public GameFrame(){
        setVisible(true);
        setResizable(false);
        setTitle(Settings.title);
        setSize(Settings.width, Settings.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPane = new JPanel();
        mainPane.setLayout(cardLayout = new CustomCardLayout(Frame.MAIN_MENU));

        mainPane.add(mainMenuPane = new MainMenuPane(), Frame.MAIN_MENU.name());
        mainPane.add(leaderboardPane = new LeaderboardPane(), Frame.LEADERBOARD.name());
        mainPane.add(gamePane = new GamePane(), Frame.GAME.name());

        add(mainPane);
    }

    public CustomCardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPane() {
        return mainPane;
    }

    public MainMenuPane getMainMenuPane() {
        return mainMenuPane;
    }

    public LeaderboardPane getLeaderboardPane() {
        return leaderboardPane;
    }

    public GamePane getGamePane() {
        return gamePane;
    }
}
