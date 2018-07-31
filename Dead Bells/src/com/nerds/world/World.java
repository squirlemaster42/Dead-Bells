package com.nerds.world;

import com.nerds.utils.Handler;

import java.awt.*;

public abstract class World {

    private final Handler handler;

    public World(final Handler handler){
        this.handler = handler;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract boolean checkPlatformCollision(int x, int y);
}
