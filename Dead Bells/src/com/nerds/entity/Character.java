package com.nerds.entity;

import com.nerds.utils.Handler;
import com.nerds.input.KeyManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Character extends Creature {

    KeyManager keyManager = new KeyManager();

    public Character(Handler handler, float x, float y, int width, int height, BufferedImage texture) {
        super(handler, x, y, width, height, texture);
    }

    @Override
    public void tick(){

        if(keyManager.w) {
            yMove = -5;
        }
        else if(keyManager.s){
            yMove = 5;
        }
        else{
            y = 0;
        }

        if(keyManager.a){
            xMove = -5;
        }
        else if(keyManager.d){
            xMove = 5;
        }
        else{
            xMove = 0;
        }
        super.move();
    }

    @Override
    public void render(Graphics g){
        g.drawImage(texture, (int) x, (int) y, width, height, null);
    }
}
