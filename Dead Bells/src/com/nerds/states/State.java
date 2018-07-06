package com.nerds.states;

import com.nerds.utils.Handler;
import com.nerds.world.World;

import java.awt.Graphics;

public abstract class State {

    private final String name;
    private static State currentState;
    final Handler handler;

    public State(final Handler handler, final String name){
        this.handler = handler;
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
