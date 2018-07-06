package com.nerds.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character extends Creature {

    private static boolean w, a, s, d;

    @Override
    public void tick(){
        w = keys[KeyEvent.VK_W];
        s = keys[KeyEvent.VK_S];
        a = keys[KeyEvent.VK_A];
        d = keys[KeyEvent.VK_D];
    }

    @Override
    public void render(){

    }
}
