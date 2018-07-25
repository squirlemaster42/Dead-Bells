package com.nerds.world;

import com.nerds.entity.Entity;
import com.nerds.entity.Player;
import com.nerds.graphics.Assets;
import com.nerds.platforms.Platform;
import com.nerds.utils.Handler;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {

    private final ArrayList<Entity> entities;
    private final Player character;
    private final Platform centerIsland;

    public World(final Handler handler){
        character = new Player(handler, 100f, 100f, 64, 64, Assets.tree);
        centerIsland = new Platform(300, 300, 400, 100);
        entities = new ArrayList<>();
    }

    public void tick(){
        character.tick();
    }

    public void render(Graphics g){
        g.drawImage(Assets.testWorld, 0, 0, 1280, 720, null);

        character.render(g);
        centerIsland.render(g);
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }

    public boolean collisionWithPlatform(int x, int y){
        return centerIsland.contains(x, y);
    }
}
