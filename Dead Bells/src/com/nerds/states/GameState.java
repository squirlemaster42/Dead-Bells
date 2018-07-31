package com.nerds.states;

import com.nerds.utils.Handler;
import com.nerds.world.TestWorld;
import com.nerds.world.World;

import java.awt.Graphics;

public class GameState extends State {

    private final World world;

    public GameState(final Handler handler) {
        super(handler,"gameState");

        world = new TestWorld(handler);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    @Override
    public World getWorld() {
        return world;
    }
}
