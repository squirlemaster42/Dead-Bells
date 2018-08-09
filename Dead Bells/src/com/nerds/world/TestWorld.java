package com.nerds.world;

import com.nerds.entity.Player;
import com.nerds.graphics.Assets;
import com.nerds.platforms.Platform;
import com.nerds.utils.Handler;

import java.awt.*;
import java.util.ArrayList;

public class TestWorld extends World {

    private final ArrayList<Platform> platformArray;
    private final Player player;

    public TestWorld(Handler handler) {
        super(handler);
        platformArray = new ArrayList<>();
        platformArray.add(new Platform(300, 300, 300, 30));
        player = new Player(handler, 50, 50, 64, 64);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.testWorld, 0, 0, 1280, 720, null);

        for(Platform p : platformArray) {
            p.render(g);
        }

        player.render(g);
    }

    @Override
    public boolean checkPlatformCollision(int x, int y) {
        for(Platform p : platformArray) {
            if(p.intersects(new Rectangle(x, y, player.bounds.width, player.bounds.height))){
                return true;
            }
        }
        return false;
    }
}
