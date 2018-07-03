package com.nerds.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity {

    protected float x, y;

    private final int width, height;
    private final BufferedImage texture;

    protected final Rectangle bounds;

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

    public boolean checkEntityCollision(float xOffset, float yOffset, ArrayList<Entity> entities){
        for(Entity e : entities){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }

        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y +yOffset), bounds.width, bounds.height);
    }
}
