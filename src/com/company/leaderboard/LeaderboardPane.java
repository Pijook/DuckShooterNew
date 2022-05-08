package com.company.leaderboard;

import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardPane extends JPanel {

    public LeaderboardPane(){
        JList<PlayerScore> playerScoreJList = new JList<>();

        playerScoreJList.setModel(new LeaderboardModel());

        playerScoreJList.setCellRenderer(new ListCellRenderer<PlayerScore>() {

            final PlayerScoreView playerScoreView = new PlayerScoreView();

            @Override
            public Component getListCellRendererComponent(JList<? extends PlayerScore> list, PlayerScore value, int index, boolean isSelected, boolean cellHasFocus) {
                if(value != null){
                    playerScoreView.setPlayerScore(value);
                }
                return playerScoreView;
            }
        });

        JButton returnButton = new JButton("Return");

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.MAIN_MENU.name());
            }
        });

        add(playerScoreJList);
        add(returnButton);
    }

}
