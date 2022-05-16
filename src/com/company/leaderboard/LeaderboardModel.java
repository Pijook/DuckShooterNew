package com.company.leaderboard;

import com.company.Controllers;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class LeaderboardModel extends AbstractListModel<PlayerScore> {

    private List<PlayerScore> playerScores;

    public LeaderboardModel(){
        playerScores = Controllers.getLeaderboardController().getPlayerScores();
    }

    @Override
    public int getSize() {
        return playerScores.size();
    }

    @Override
    public PlayerScore getElementAt(int index) {
        return playerScores.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }
}
