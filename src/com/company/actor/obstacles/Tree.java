package com.company.actor.obstacles;

import com.company.Assets;
import com.company.actor.MovingActor;
import com.company.actor.Position;

import java.util.Random;


public class Tree extends MovingActor {

    public Tree(Position position) {
        super(Assets.trees[new Random().nextInt(Assets.trees.length)],
                position,
                true,
                0);
        setLayer("obstacleLayer");
    }

}
