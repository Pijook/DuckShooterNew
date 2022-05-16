package com.company;

import com.company.game.difficulty.DifficultyPane;
import com.company.game.GamePane;
import com.company.leaderboard.LeaderboardPane;
import com.company.menu.MainMenuPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {

    private CustomCardLayout cardLayout;

    //Panes
    private JPanel mainPane;
    private MainMenuPane mainMenuPane;
    private LeaderboardPane leaderboardPane;
    private GamePane gamePane;
    private DifficultyPane difficultyPane;

    public GameFrame(){
        setIconImage(Assets.programIcon.getImage());
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
        mainPane.add(difficultyPane = new DifficultyPane(), Frame.DIFFICULTY.name());

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
        mainPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "closeHotkey");
        mainPane.getActionMap().put("closeHotkey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.save();
                System.exit(0);
            }
        });

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

    public DifficultyPane getDifficultyPane() {
        return difficultyPane;
    }
}
