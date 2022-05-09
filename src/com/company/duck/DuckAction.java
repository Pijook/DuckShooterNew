package com.company.duck;

import com.company.Controllers;
import com.company.Main;
import com.company.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckAction implements ActionListener {

    private final Duck duck;

    public DuckAction(Duck duck){
        this.duck = duck;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Controllers.getGameController().getAmmo() <= 0){
            return;
        }

        int damage = Controllers.getGameController().getDamage() + Controllers.getGameController().getDamageUpgrade();
        System.out.println(damage);
        duck.setLives(duck.getLives() - damage);

        Controllers.getGameController().setAmmo(Controllers.getGameController().getAmmo() - 1);

        if(duck.getLives() <= 0){
            duck.setAlive(false);
            Controllers.getGameController().setScore(Controllers.getGameController().getScore() + duck.getScore());
        }
    }
}
