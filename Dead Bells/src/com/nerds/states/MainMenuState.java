package com.nerds.states;

import com.nerds.utils.Handler;
import com.nerds.world.World;

import java.awt.Graphics;

public class MainMenuState extends State{

    public MainMenuState(final Handler handler) {
        super(handler,"MainMenu");
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public World getWorld() {
        return null;
    }
}
