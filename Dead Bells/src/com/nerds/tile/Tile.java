package com.nerds.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile{

    private final float x, y;
    private final int width, height;
    private final BufferedImage image;

    public Tile(final float x, final float y, final int width, final int height, BufferedImage image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean isSolid(){
        return false;
    }
}