package com.nerds.entity;

import com.nerds.utils.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

    private final Handler handler;
    protected final Rectangle bounds;

    public Entity(final Handler handler, final int x, final int y, final int width, final int height){
        this.handler = handler;
        bounds = new Rectangle(x, y, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    protected Handler getHandler(){
        return handler;
    }
}
