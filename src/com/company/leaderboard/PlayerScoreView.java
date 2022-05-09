package com.company.leaderboard;

import com.company.Assets;

import javax.swing.*;
import java.awt.*;

public class PlayerScoreView extends JPanel {

    private final JLabel playerName;
    private final JLabel playerScore;

    public PlayerScoreView(){
        playerName = new JLabel();
        playerName.setFont(Assets.rainyHeartsFont.deriveFont(24f).deriveFont(Font.BOLD));

        playerScore = new JLabel();
        playerScore.setFont(Assets.rainyHeartsFont.deriveFont(24f).deriveFont(Font.BOLD));

        add(playerName);
        add(playerScore);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
