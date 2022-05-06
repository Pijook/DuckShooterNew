package com.company.leaderboard;

import javax.swing.*;
import java.awt.*;

public class PlayerScoreView extends JPanel {

    private final JLabel playerName;
    private final JLabel playerScore;

    public PlayerScoreView(){
        playerName = new JLabel();
        playerScore = new JLabel();

        add(playerName);
        add(playerScore);
    }

    public void setPlayerScore(PlayerScore score){
        playerName.setText(score.nickname());
        playerScore.setText(String.valueOf(score.score()));
    }

    public JLabel getPlayerName() {
        return playerName;
    }

    public JLabel getPlayerScore() {
        return playerScore;
    }
}
