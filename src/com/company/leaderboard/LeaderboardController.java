package com.company.leaderboard;

import com.company.Main;

import java.io.*;
import java.util.*;

public class LeaderboardController {

    private List<PlayerScore> playerScores;

    public LeaderboardController(){
        playerScores = new ArrayList<>();
    }

    public void load() throws IOException, ClassNotFoundException {
        System.out.println("Loading...");
        File file = new File("leaderboard.txt");

        if(!file.exists()){
            System.out.println("File doesn't exists!");
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
        System.out.println("Saving...");
        File file = new File("leaderboard.txt");

        if(file.exists()){
           file.delete();
        }
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(playerScores);
        objectOutputStream.close();
    }

    public void add(String nickname, int score, int reloadUpgrade, int damageUpgrade, int time){
        playerScores.add(new PlayerScore(nickname, score, reloadUpgrade, damageUpgrade, time));

        playerScores.sort(new Comparator<>() {
            @Override
            public int compare(PlayerScore o1, PlayerScore o2) {
                return o2.score().compareTo(o1.score());
            }
        });

        for(PlayerScore playerScore : playerScores){
            System.out.println(playerScore);
        }

        Main.getGameFrame().getLeaderboardPane().updateList();
        //Main.getGameFrame().getLeaderboardPane().getLeaderboardModel().setPlayerScores(playerScores);
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }
}
