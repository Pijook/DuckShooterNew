package com.company.leaderboard;

import com.company.Assets;

import javax.swing.*;
import java.awt.*;

public class PlayerScoreView extends JPanel {

    private final JLabel playerScore;

    public PlayerScoreView(){
        playerScore = new JLabel();
        playerScore.setFont(Assets.rainyHeartsFont.deriveFont(24f).deriveFont(Font.BOLD));

        add(playerScore);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void setPlayerScore(PlayerScore score){
        playerScore.setText(score.nickname() + " " + score.score());
    }

    public JLabel getPlayerScore() {
        return playerScore;
    }
}
