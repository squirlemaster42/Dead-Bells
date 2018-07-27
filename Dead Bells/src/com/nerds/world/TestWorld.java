package com.nerds.world;

import com.nerds.utils.Handler;

public class TestWorld extends World {

    public TestWorld(Handler handler) {
        super(handler);
    }

    @Override
    public boolean checkPlatformCollision(int x, int y) {
        return false;
    }
}
