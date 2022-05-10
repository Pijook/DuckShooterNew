package com.company.actor.duck;

public class MediumDuck extends Duck{

    public MediumDuck(Position position, boolean left) {
        super(2, 250, 2, 10, position, left);
        setText("Medium Duck");
    }
}
