package com.nerds.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile{

    //Constants
    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;

    private static final Map<Integer, Class<? extends Tile>> tileMap = new HashMap<>();

    public static void initTileMap(){
        tileMap.put(0, GrassTile.class);
        tileMap.put(1, DirtTile.class);
        tileMap.put(2, RockTile.class);
        tileMap.put(3, StoneBrickTile.class);
        tileMap.put(4, AlienTile.class);
        tileMap.put(5, TreeTile.class);
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

    public static Class getMapValue(int key){
        return tileMap.get(key);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean isSolid(){
        return false;
    }
}