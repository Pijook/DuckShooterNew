package com.company.actor.duck;

import com.company.Assets;
import com.company.actor.Position;

import javax.swing.*;

public class MediumDuck extends Duck{

    public MediumDuck(Position position, boolean left, ImageIcon imageIcon) {
        super(2, 250, 2, 5, position, left, imageIcon);
    }
}
