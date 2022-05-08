package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Textures {

    public static BufferedImage duckImage;

    public static void load() throws IOException {
        duckImage = ImageIO.read(new File("resources/duck.png"));
    }

}
