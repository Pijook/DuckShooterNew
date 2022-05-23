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

    public static ImageIcon[] duckLeft;
    public static ImageIcon[] duckRight;

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

        //animatedDuckLeft = new ImageIcon("resources/textures/duckLeft.gif");
        //animatedDuckRight = new ImageIcon("resources/textures/duckRight.gif");
        duckLeft = new ImageIcon[3];
        duckRight = new ImageIcon[3];
        //animatedDuckLeft = new ImageIcon("resources/textures/duckFramesSmall/hard/brown_duck.gif");
        //animatedDuckRight = new ImageIcon("resources/textures/duckFramesSmall/hard/brown_duck.gif");

        backgroundImage = new ImageIcon("resources/textures/backgroundBig.png");

        blueButtonImage = new ImageIcon("resources/textures/ui/blueButtonBig.png");
        greenButtonImage = new ImageIcon("resources/textures/ui/greenButtonBig.png");
        pinkRedButtonImage = new ImageIcon("resources/textures/ui/pinkRedButton.png");
        yellowButtonImage = new ImageIcon("resources/textures/ui/yellowButton.png");

        clouds = new ImageIcon[8];
        for(int i = 1; i <= 8; i++){
            clouds[i - 1] = new ImageIcon("resources/textures/obstacles/cloud" + i + ".png");
        }

        /*trees = new ImageIcon[2];
        for(int i = 1; i <= 2; i++){
            trees[i - 1] = new ImageIcon("resources/textures/obstacles/tree" + i + ".png");
            System.out.println(trees[i - 1].getIconWidth());
        }*/

        scaleImages();
    }

    private static void scaleImages(){
        //animatedDuckLeft.setImage(animatedDuckLeft.getImage().getScaledInstance(animatedDuckLeft.getIconWidth() * 4, animatedDuckLeft.getIconHeight() * 4, Image.SCALE_DEFAULT));
        //animatedDuckRight.setImage(animatedDuckRight.getImage().getScaledInstance(animatedDuckRight.getIconWidth() * 4, animatedDuckRight.getIconHeight() * 4, Image.SCALE_DEFAULT));
    }

    private static void loadSounds() throws UnsupportedAudioFileException, IOException {
        peacefulDuckSong = AudioSystem.getAudioInputStream(new File("resources/music/peacefulduckmusic.wav"));
        //quackSound = AudioSystem.getAudioInputStream(new File("resources/music/quackSound.wav"));

        //TODO Add quacking in the 90's as music
    }

}
