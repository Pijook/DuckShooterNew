package com.company.leaderboard;

import java.io.Serializable;

public record PlayerScore(String nickname, Integer score, int reloadUpgrade, int damageUpgrade, int time) implements Serializable {

    @Override
    public String toString() {
        return "PlayerScore{" +
                "nickname='" + nickname + '\'' +
                ", score=" + score +
                ", reloadUpgrade=" + reloadUpgrade +
                ", damageUpgrade=" + damageUpgrade +
                ", time=" + time +
                '}';
    }
}
