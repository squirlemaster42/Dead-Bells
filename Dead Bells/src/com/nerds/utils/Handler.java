package com.nerds.utils;

import com.nerds.main.Game;

public class Handler {

    private final Game game;

    public Handler(final Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }
}
