package com.company.option;

import com.company.Assets;

import javax.swing.*;
import java.awt.*;

public class ResolutionView extends JPanel {

    private JLabel resolutionLabel;

    public ResolutionView(){
        resolutionLabel = new JLabel();
        resolutionLabel.setFont(Assets.rainyHeartsFont.deriveFont(24f).deriveFont(Font.BOLD));

        add(resolutionLabel);
    }

    public void setResolution(Resolution resolution){
        resolutionLabel.setText(resolution.getWidth() + "x" + resolution.getHeight());
    }

    public JLabel getResolutionLabel() {
        return resolutionLabel;
    }

    public void setResolutionLabel(JLabel resolutionLabel) {
        this.resolutionLabel = resolutionLabel;
    }
}
