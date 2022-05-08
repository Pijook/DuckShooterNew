package com.company;

import com.company.game.GameController;
import com.company.leaderboard.LeaderboardController;

public class Controllers {

    private static LeaderboardController leaderboardController;
    private static GameController gameController;

    public static void create(){
        leaderboardController = new LeaderboardController();
        gameController = new GameController();
    }

    public static LeaderboardController getLeaderboardController() {
        return leaderboardController;
    }

    public static GameController getGameController() {
        return gameController;
    }
}
