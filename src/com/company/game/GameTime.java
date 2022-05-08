package com.company.game;

public class GameTime extends Thread {

    private final GameController gameController;

    public GameTime(){
        gameController = new GameController();
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted() && gameController.isGameActive()){
            System.out.println("abc");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            gameController.setTime(gameController.getTime() + 1);
        }
        System.out.println("erorror");
        System.out.println(isInterrupted());
        System.out.println(gameController.isGameActive());
    }
}
