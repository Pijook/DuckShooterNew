package com.company.menu;

import com.company.Assets;

import javax.swing.*;

public class MenuButton extends JButton {

    public MenuButton(String text){
        setText(text);
        setFont(Assets.rainyHeartsFont.deriveFont(36f));
        setIcon(Assets.greenButtonImage);
        setHorizontalTextPosition(SwingUtilities.HORIZONTAL);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

}
