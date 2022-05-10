package com.company;

import com.company.game.GameController;
import com.company.leaderboard.LeaderboardController;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class Controllers {

    private static LeaderboardController leaderboardController;
    private static GameController gameController;

    public static void create() throws LineUnavailableException, IOException {
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
