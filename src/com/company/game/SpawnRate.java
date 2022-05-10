package com.company.game;

public class SpawnRate {

    private int spawnRate;
    private int tempRate;
    private int decreaseRate;

    public SpawnRate(int spawnRate, int tempRate, int decreaseRate) {
        this.spawnRate = spawnRate;
        this.tempRate = tempRate;
        this.decreaseRate = decreaseRate;
    }

    public void decreaseSpawnRate(){
        spawnRate = spawnRate - decreaseRate;
    }

    public boolean readyToSpawn(){
        return tempRate >= spawnRate;
    }

    public void resetSpawnRate(){
        tempRate = 0;
    }

    public int getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public int getTempRate() {
        return tempRate;
    }

    public void setTempRate(int tempRate) {
        this.tempRate = tempRate;
    }

    public int getDecreaseRate() {
        return decreaseRate;
    }

    public void setDecreaseRate(int decreaseRate) {
        this.decreaseRate = decreaseRate;
    }
}
