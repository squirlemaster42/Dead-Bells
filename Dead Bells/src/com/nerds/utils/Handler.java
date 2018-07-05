package com.nerds.utils;

import com.nerds.main.Game;
import com.nerds.states.State;
import com.nerds.world.World;

public class Handler {

    private final Game game;

    public Handler(final Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }

    public World getWorld(){
        return State.getCurrentState().getWorld();
    }
}
