package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {

    /*
        Textures
     */
    public static ImageIcon programIcon;

    //public static ImageIcon animatedDuckLeft;
    //public static ImageIcon animatedDuckRight;

    //Easy
    public static ImageIcon easyDuckLeft;
    public static ImageIcon easyDuckRight;
    //Medium
    public static ImageIcon mediumDuckLeft;
    public static ImageIcon mediumDuckRight;
    //Hard
    public static ImageIcon hardDuckLeft;
    public static ImageIcon hardDuckRight;

    public static ImageIcon backgroundImage;

    public static ImageIcon blueButtonImage;
    public static ImageIcon greenButtonImage;
    public static ImageIcon pinkRedButtonImage;
    public static ImageIcon yellowButtonImage;

    public static ImageIcon[] clouds;
    public static ImageIcon[] trees;

    /*
        Music
     */
    public static AudioInputStream peacefulDuckSong;
    public static AudioInputStream quackSound;

    /*
        Fonts
     */
    public static Font rainyHeartsFont;

    public static void load() throws IOException, FontFormatException, UnsupportedAudioFileException {
        loadTextures();
        loadFonts();
        loadSounds();
    }

    private static void loadFonts() throws IOException, FontFormatException {
        rainyHeartsFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/rainyhearts.ttf"));
        rainyHeartsFont = rainyHeartsFont.deriveFont(12f);
    }

    private static void loadTextures() {
        programIcon = new ImageIcon("resources/textures/icon.png");

        easyDuckLeft = new ImageIcon("resources/textures/duckFramesSmall/easy/duckWhiteLeft.gif");
        easyDuckRight = new ImageIcon("resources/textures/duckFramesSmall/easy/duckWhiteRight.gif");

        mediumDuckLeft = new ImageIcon("resources/textures/duckFramesSmall/medium/duckGreenLeft.gif");
        mediumDuckRight = new ImageIcon("resources/textures/duckFramesSmall/medium/duckGreenRight.gif");

        hardDuckLeft = new ImageIcon("resources/textures/duckFramesSmall/hard/duckBrownLeft.gif");
        hardDuckRight = new ImageIcon("resources/textures/duckFramesSmall/hard/duckBrownRight.gif");

        backgroundImage = new ImageIcon("resources/textures/backgroundBig.png");

        blueButtonImage = new ImageIcon("resources/textures/ui/blueButtonBig.png");
        greenButtonImage = new ImageIcon("resources/textures/ui/greenButtonBig.png");
        pinkRedButtonImage = new ImageIcon("resources/textures/ui/pinkRedButton.png");
        yellowButtonImage = new ImageIcon("resources/textures/ui/yellowButton.png");

        clouds = new ImageIcon[8];
        for(int i = 1; i <= clouds.length; i++){
            clouds[i - 1] = new ImageIcon("resources/textures/obstacles/cloud" + i + ".png");
        }

        trees = new ImageIcon[2];
        for(int i = 1; i <= 2; i++){
            trees[i - 1] = new ImageIcon("resources/textures/obstacles/tree" + i + ".png");
            System.out.println(trees[i - 1].getIconWidth());
        }

        scaleImages();
    }

    private static void scaleImages(){
        int duckScaleRatio = 2;
        //Easy
        easyDuckLeft.setImage(easyDuckLeft.getImage().getScaledInstance(easyDuckLeft.getIconWidth() * duckScaleRatio, easyDuckLeft.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));
        easyDuckRight.setImage(easyDuckRight.getImage().getScaledInstance(easyDuckRight.getIconWidth() * duckScaleRatio, easyDuckRight.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));
        //Medium
        mediumDuckLeft.setImage(mediumDuckLeft.getImage().getScaledInstance(mediumDuckLeft.getIconWidth() * duckScaleRatio, mediumDuckLeft.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));
        mediumDuckRight.setImage(mediumDuckRight.getImage().getScaledInstance(mediumDuckRight.getIconWidth() * duckScaleRatio, mediumDuckRight.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));
        //Hard
        hardDuckLeft.setImage(hardDuckLeft.getImage().getScaledInstance(hardDuckLeft.getIconWidth() * duckScaleRatio, hardDuckLeft.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));
        hardDuckRight.setImage(hardDuckRight.getImage().getScaledInstance(hardDuckRight.getIconWidth() * duckScaleRatio, hardDuckRight.getIconHeight() * duckScaleRatio, Image.SCALE_DEFAULT));

        //Clouds
        int cloudScaleRatio = 7;
        for(int i = 0; i < clouds.length; i++){
            ImageIcon imageIcon = clouds[i];
            clouds[i].setImage(clouds[i].getImage().getScaledInstance(imageIcon.getIconWidth() * cloudScaleRatio, imageIcon.getIconHeight() * cloudScaleRatio, Image.SCALE_DEFAULT));
        }

        //Trees
        int treeScaleRatio = 2;
        for(int i = 0; i < trees.length; i++){
            ImageIcon imageIcon = trees[i];
            trees[i].setImage(trees[i].getImage().getScaledInstance(imageIcon.getIconWidth() * treeScaleRatio, imageIcon.getIconHeight() * treeScaleRatio, Image.SCALE_DEFAULT));
        }
    }

    private static void loadSounds() throws UnsupportedAudioFileException, IOException {
        peacefulDuckSong = AudioSystem.getAudioInputStream(new File("resources/music/peacefulduckmusic.wav"));

        //TODO Add quacking in the 90's as music
    }

}
