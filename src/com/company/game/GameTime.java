package com.company.game;

import com.company.Controllers;

public class GameTime extends Thread {

    private final GameController gameController;
    private int counter;

    public GameTime(){
        gameController = Controllers.getGameController();
        counter = 0;
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted() && gameController.isGameActive()){
            try {
                sleep(1000);
                counter++;
                if(counter == 5){
                    if(gameController.getDuckSpawnRate().getSpawnRate() > 10){
                        gameController.getDuckSpawnRate().decreaseSpawnRate();
                        gameController.getObstacleSpawnRate().decreaseSpawnRate();
                        counter = 0;
                    }

                }
            } catch (InterruptedException e) {
                break;
            }
            gameController.setTime(gameController.getTime() + 1);
        }
    }
}
