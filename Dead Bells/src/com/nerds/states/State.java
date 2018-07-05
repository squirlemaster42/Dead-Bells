package com.nerds.states;

import com.nerds.world.World;

import java.awt.Graphics;

public abstract class State {

    private final String name;
    private static State currentState;

    public State(final String name){
        this.name = name;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract World getWorld();

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }
}
