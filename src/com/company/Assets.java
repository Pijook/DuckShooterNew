package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
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

    private static void loadTextures() throws IOException {
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
        }

        scaleImages(1, 1);
    }

    public static void scaleImages(double widthMultiplier, double heightMultiplier){
        System.out.println(widthMultiplier + " " + heightMultiplier);

        widthMultiplier = widthMultiplier * 100;
        widthMultiplier = (int) widthMultiplier;
        widthMultiplier = widthMultiplier / 100;

        heightMultiplier = heightMultiplier * 100;
        heightMultiplier = (int) heightMultiplier;
        heightMultiplier = heightMultiplier / 100;

        double duckScaleX = 2 * widthMultiplier;
        double duckScaleY = 2 * heightMultiplier;
        //Easy
        easyDuckLeft.setImage(scaleImage(easyDuckLeft, duckScaleX, duckScaleY));
        easyDuckRight.setImage(scaleImage(easyDuckRight, duckScaleX, duckScaleY));
        //Medium
        mediumDuckLeft.setImage(scaleImage(mediumDuckLeft, duckScaleX, duckScaleY));
        mediumDuckRight.setImage(scaleImage(mediumDuckRight, duckScaleX, duckScaleY));
        //Hard
        hardDuckLeft.setImage(scaleImage(hardDuckLeft, duckScaleX, duckScaleY));
        hardDuckRight.setImage(scaleImage(hardDuckRight, duckScaleX, duckScaleY));

        //Clouds
        double cloudScaleX = 10 * widthMultiplier;
        double cloudScaleY = 10 * heightMultiplier;
        for(int i = 0; i < clouds.length; i++){
            clouds[i].setImage(scaleImage(clouds[i], cloudScaleX, cloudScaleY));
        }

        //Trees
        double treeScaleX = 2 * widthMultiplier;
        double treeScaleY = 2 * heightMultiplier;
        for(int i = 0; i < trees.length; i++){
            trees[i].setImage(scaleImage(trees[i], treeScaleX, treeScaleY));
        }

        double buttonScaleX = 0.8 * widthMultiplier;
        double buttonScaleY = 0.8 * heightMultiplier;
        System.out.println(buttonScaleX);
        greenButtonImage.setImage(scaleImage(greenButtonImage, buttonScaleX, buttonScaleY));

        double backgroundScaleX = 1 * widthMultiplier;
        double backgroundScaleY = 1 * heightMultiplier;
        backgroundImage.setImage(scaleImage(backgroundImage, backgroundScaleX, backgroundScaleY));
        
        
    }

    private static Image scaleImage(ImageIcon image, double scaleX, double scaleY){
        return image.getImage().getScaledInstance((int) (image.getIconWidth() * scaleX), (int) (image.getIconHeight() * scaleY), java.awt.Image.SCALE_DEFAULT);
    }

    private static void loadSounds() throws UnsupportedAudioFileException, IOException {
        peacefulDuckSong = AudioSystem.getAudioInputStream(new File("resources/music/peacefulduckmusic.wav"));

    }

}
