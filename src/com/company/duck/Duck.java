package com.company.duck;

public abstract class Duck {

    private final int lives;
    private final int score;
    private final int damage;

    public Duck(int lives, int score, int damage) {
        this.lives = lives;
        this.score = score;
        this.damage = damage;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public int getDamage() {
        return damage;
    }
}
