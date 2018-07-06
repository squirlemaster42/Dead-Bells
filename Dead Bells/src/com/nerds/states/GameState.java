package com.nerds.states;

import com.nerds.world.World;

import java.awt.*;

public class GameState extends State {

    public GameState(){
        super("gameState");
    }

    private final World world = new World("TODO");

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
        return null;
    };
}
