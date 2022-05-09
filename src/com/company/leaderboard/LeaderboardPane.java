package com.company.leaderboard;

import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderboardPane extends JPanel {

    private JList<PlayerScore> playerScoreJList;
    private LeaderboardModel leaderboardModel;

    public LeaderboardPane(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        playerScoreJList = new JList<>();
        leaderboardModel = new LeaderboardModel();

        playerScoreJList.setModel(leaderboardModel);

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

        gridBagConstraints.ipadx = 100;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(playerScoreJList, gridBagConstraints);

        gridBagConstraints.insets = new Insets(25, 0, 0, 0);
        gridBagConstraints.gridy = 1;

        add(returnButton, gridBagConstraints);
    }

    public void updateList(){
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
    }

    public JList<PlayerScore> getPlayerScoreJList() {
        return playerScoreJList;
    }

    public LeaderboardModel getLeaderboardModel() {
        return leaderboardModel;
    }
}
