package com.company.game;

import com.company.Assets;

import javax.swing.*;

public class UpgradeButton extends JButton {

    public UpgradeButton(String text){
        setText(text);
        setFont(Assets.rainyHeartsFont.deriveFont(36f));
        setIcon(Assets.greenButtonImage);
        setHorizontalTextPosition(SwingUtilities.HORIZONTAL);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

}
