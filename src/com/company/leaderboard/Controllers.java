package com.company.leaderboard;

public class Controllers {

    private static LeaderboardController leaderboardController;

    public static void create(){
        leaderboardController = new LeaderboardController();
    }

    public static LeaderboardController getLeaderboardController() {
        return leaderboardController;
    }
}
