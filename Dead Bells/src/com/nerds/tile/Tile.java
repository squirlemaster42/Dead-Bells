package com.nerds.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile{

    //Constants
    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;

    private static final Map<Integer, Class> tileMap = new HashMap<>();

    public static void initTileMap(){
        tileMap.put(0, GrassTile.class);
    }

    private final float x, y;
    private final BufferedImage image;
    private final int tileID;

    public Tile(final int tileID, final float x, final float y, BufferedImage image){
        this.x = x;
        this.y = y;
        this.image = image;
        this.tileID = tileID;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean isSolid(){
        return false;
    }
}