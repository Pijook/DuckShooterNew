package com.company.duck;

import com.company.Controllers;
import com.company.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckAction implements ActionListener {

    private final Duck duck;

    public DuckAction(Duck duck){
        this.duck = duck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        duck.setLives(duck.getLives() - 1);
        duck.setText("Hits: " + duck.getLives());
        if(duck.getLives() <= 0){
            duck.setAlive(false);
            Controllers.getGameController().setScore(Controllers.getGameController().getScore() + duck.getScore());
        }
    }
}
