package com.company.actor.obstacles;

import com.company.Assets;
import com.company.Main;
import com.company.Settings;
import com.company.actor.MovingActor;
import com.company.actor.Position;

import javax.swing.*;
import java.util.Random;

public class Cloud extends MovingActor {

    public static Cloud spawnCloud(){
        Random random = new Random();

        ImageIcon texture = Assets.clouds[random.nextInt(Assets.clouds.length)];

        int bound = Main.getGameFrame().getGamePane().getShootingLayers().get("cloudLayer").getHeight();
        int difference = Main.getGameFrame().getGamePane().getHeight() - bound;
        difference = difference/2;

        boolean isLeft = random.nextBoolean();

        Position position;
        if(isLeft){
            position = new Position(
                    Settings.getCurrentResolution().getWidth(),
                    random.nextInt(bound) - difference
            );
        }
        else{
            position = new Position(
                    0,
                    random.nextInt(bound) - difference
            );
        }

        int speed = random.nextInt(5) + 3;

        return new Cloud(texture, position, isLeft, speed);
    }

    public Cloud(ImageIcon imageIcon, Position position, boolean left, int speed) {
        super(imageIcon, position, left, speed);
        setLayer("cloudLayer");
    }



}
