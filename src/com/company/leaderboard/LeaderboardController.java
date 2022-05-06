package com.company.leaderboard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardController {

    private List<PlayerScore> playerScores;

    public LeaderboardController(){
        playerScores = new ArrayList<>();
    }

    public void load() throws IOException, ClassNotFoundException {
        File file = new File("leaderboard.txt");

        if(!file.exists()){
            playerScores.add(new PlayerScore("Pijok_", 100, 1,1, 50));
            playerScores.add(new PlayerScore("Fade", 140, 1,3, 530));
            playerScores.add(new PlayerScore("Fezio", 150, 2,1, 90));
            return;
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        playerScores = (List<PlayerScore>) objectInputStream.readObject();
        objectInputStream.close();
    }

    public void save() throws IOException {
        File file = new File("leaderboard.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(playerScores);;
        objectOutputStream.close();
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }
}
