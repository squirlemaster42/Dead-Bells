package com.nerds.states;

import com.nerds.world.World;

import java.awt.*;

public class GameState extends State {

    private final World world;

    public GameState(){
        super("gameState");
        world = new World("TODO");
    }

    @Override
    public void tick(){
        world.tick();
    };

    @Override
    public void render(Graphics g){
        world.render(g);
    };

    @Override
    public World getWorld(){
        return world;
    };
}
