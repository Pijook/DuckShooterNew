package com.company.option;

import com.company.Assets;

import javax.swing.*;

public class OptionButton extends JButton {

    public OptionButton(String text){
        setText(text);
        setFont(Assets.rainyHeartsFont.deriveFont(24f));
        setIcon(Assets.greenButtonImage);
        setHorizontalTextPosition(SwingUtilities.HORIZONTAL);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

}
