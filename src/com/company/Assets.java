package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {

    public static BufferedImage duckTestImage;
    public static ImageIcon animatedDuckImage;
    public static ImageIcon animatedDuckSmallImage;
    public static ImageIcon animatedDuckBigImage;

    public static Font rainyHeartsFont;

    public static void load() throws IOException, FontFormatException {
        loadTextures();
        loadFonts();
    }

    private static void loadFonts() throws IOException, FontFormatException {
        rainyHeartsFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/rainyhearts.ttf"));
        rainyHeartsFont = rainyHeartsFont.deriveFont(12f);
    }

    private static void loadTextures() throws IOException {
       // duckTestImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage("resources/textures/duckTest.png"));
        duckTestImage = ImageIO.read(new File("resources/textures/duckTest.png"));
        animatedDuckImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage("resources/textures/duckAnimated.gif"));
        animatedDuckSmallImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage("resources/textures/duckAnimatedSmall.gif"));
        animatedDuckBigImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage("resources/textures/duckAnimatedBig.gif"));

        //System.out.println(duckTestImage.getIconHeight());
    }

}
