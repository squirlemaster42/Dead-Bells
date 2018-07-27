package com.nerds.states;

import com.nerds.utils.Handler;
import com.nerds.world.World;

import java.awt.Graphics;

public class GameState extends State {

    private final World world;

    public GameState(final Handler handler) {
        super(handler,"gameState");

        world = null;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public World getWorld() {
        return world;
    }
}
