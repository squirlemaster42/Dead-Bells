package com.nerds.entity;

import com.nerds.utils.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Character extends Creature {

    public Character(Handler handler, float x, float y, int width, int height, BufferedImage img) {
        super(handler, x, y, width, height, img);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){

    }
}
