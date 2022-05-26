package com.company.option;

import com.company.Assets;
import com.company.Frame;
import com.company.Main;
import com.company.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPane extends JPanel {

    private JLabel titleLabel;

    private ResolutionModel resolutionModel;
    private JComboBox<Resolution> resolutionsComboBox;
    private JSlider volumeSlider;
    private JButton saveButton;
    private JButton returnButton;

    public OptionsPane(){
        createElements();
        createLayout();
    }

    private void createElements(){

        /*
            Title label
         */
        titleLabel = new JLabel("Options");
        titleLabel.setFont(Assets.rainyHeartsFont.deriveFont(72f));

        /*
            Resolution combo box
         */
        resolutionModel = new ResolutionModel();
        resolutionsComboBox = new JComboBox<>();
        resolutionsComboBox.setModel(resolutionModel);
        resolutionsComboBox.setRenderer(new ListCellRenderer<Resolution>() {

            final ResolutionView resolutionView = new ResolutionView();

            @Override
            public Component getListCellRendererComponent(JList<? extends Resolution> list, Resolution value, int index, boolean isSelected, boolean cellHasFocus) {
                if(value != null){
                    resolutionView.setResolution(value);
                }
                return resolutionView;
            }
        });

        /*
            Volume slider
         */
        volumeSlider = new JSlider();
        volumeSlider.setValue(Settings.volumeLevel);
        volumeSlider.setOpaque(false);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintLabels(true);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setSnapToTicks(true);

        /*
            Save button
         */
        saveButton = new OptionButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.volumeLevel = volumeSlider.getValue();

                SwingUtilities.invokeLater(() -> {
                    Settings.currentResolution = resolutionModel.getSelectedResolution();

                    Main.getGameFrame().setSize(Settings.currentResolution.getWidth(), Settings.currentResolution.getHeight());
                });

            }
        });

        /*
            Return button
         */
        returnButton = new OptionButton("Return");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.MAIN_MENU.name());
            }
        });
    }

    private void createLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        /*
            Title label
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(titleLabel, gridBagConstraints);

        /*
            Resolution combo box
         */
        gridBagConstraints.insets = new Insets(45,0,0,0);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(resolutionsComboBox, gridBagConstraints);

        /*
            Volume slider
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(volumeSlider, gridBagConstraints);

        /*
            Save button
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(saveButton, gridBagConstraints);

        /*
            Return button
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(returnButton, gridBagConstraints);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();
        g.drawImage(image, 0,0,this);
        g.drawImage(image, Assets.backgroundImage.getIconWidth(), 0, this);
        g.drawImage(image, 0, Assets.backgroundImage.getIconHeight(), this);
        g.drawImage(image, Assets.backgroundImage.getIconWidth(), Assets.backgroundImage.getIconHeight(), this);
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JComboBox<Resolution> getResolutionsComboBox() {
        return resolutionsComboBox;
    }

    public JSlider getVolumeSlider() {
        return volumeSlider;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
