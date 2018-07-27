package com.nerds.world;

import com.nerds.utils.Handler;

public abstract class World {

    private final Handler handler;

    public World(final Handler handler){
        this.handler = handler;
    }

   public abstract boolean checkPlatformCollision(int x, int y);
}
