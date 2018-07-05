package com.nerds.tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile{

    //Constants
    public static final int TILEWIDTH = 32;
    public static final int TILEHEIGHT = 32;

    private final float x, y;
    private final int width, height;
    private final BufferedImage image;
    private final int tileID;

    public Tile(final int tileID, final float x, final float y, final int width, final int height, BufferedImage image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.tileID = tileID;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean isSolid(){
        return false;
    }
}