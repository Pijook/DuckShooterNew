package com.company;

import com.company.leaderboard.Frames;
import com.company.leaderboard.LeaderboardPane;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPane;

    public GameFrame(){
        setVisible(true);
        setTitle("Ducks!");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPane = new JPanel();
        mainPane.setLayout(cardLayout = new CardLayout());

        mainPane.add(new MainMenuPane(), Frames.MAIN_MENU.name());
        mainPane.add(new LeaderboardPane(), Frames.LEADERBOARD.name());

        add(mainPane);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getMainPane() {
        return mainPane;
    }

    public void setMainPane(JPanel mainPane) {
        this.mainPane = mainPane;
    }
}
