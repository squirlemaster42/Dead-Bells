package com.nerds.main;

import java.awt.Dimension;

public class Main {

    public static void main(String[] args){
        System.out.println("Hi Tre");
        Game game = new Game(new Dimension(1280, 720));
        game.start();
    }

}
