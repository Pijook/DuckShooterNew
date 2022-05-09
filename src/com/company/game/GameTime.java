package com.company.game;

import com.company.Controllers;

public class GameTime extends Thread {

    private final GameController gameController;

    public GameTime(){
        //gameController = new GameController();
        gameController = Controllers.getGameController();
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted() && gameController.isGameActive()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            gameController.setTime(gameController.getTime() + 1);
        }
    }
}
