package com.nerds.graphics;

import java.awt.image.BufferedImage;

public class Assets {


    public static BufferedImage tree, dirt, grass, rock, stoneBrick, alien, testWorld;

    private static final int width = 32, height = 32;

    public static void init(){
        SpriteSheet ground = new SpriteSheet(ImageLoader.loadImage("/textures/ground.png"));

        grass = ground.crop(0, 0, width, height);
        dirt = ground.crop(width, 0, width, height);
        rock = ground.crop(width * 2, 0, width, height);
        stoneBrick = ground.crop(width * 3, 0, width, height);
        tree = ground.crop(0, height, width, height);
        alien = ground.crop(width, height, width, height);

        testWorld = ImageLoader.loadImage("/textures/world.png");
    }
}
