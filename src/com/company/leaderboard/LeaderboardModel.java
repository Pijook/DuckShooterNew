package com.company.leaderboard;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardModel implements ListModel<PlayerScore> {

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
}
