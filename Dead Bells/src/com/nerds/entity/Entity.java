package com.nerds.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private float x, y;
    private int width, height;
    private BufferedImage texture;

    public Entity(float x, float y, int width, int height, BufferedImage texture){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
