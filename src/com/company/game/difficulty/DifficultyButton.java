package com.company.game.difficulty;

import com.company.Assets;

import javax.swing.*;

public class DifficultyButton extends JButton {

    public DifficultyButton(String text){
        setText(text);
        setFont(Assets.rainyHeartsFont.deriveFont(36f));
        setIcon(Assets.greenButtonImage);
        setHorizontalTextPosition(SwingUtilities.HORIZONTAL);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

}
