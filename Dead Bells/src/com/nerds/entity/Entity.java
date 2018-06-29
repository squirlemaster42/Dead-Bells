package com.nerds.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private final float x, y;
    private final int width, height;
    private final BufferedImage texture;

    private final Rectangle bounds;

    public Entity(final float x, final float y, final int width, final int height, final BufferedImage texture){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;

        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
