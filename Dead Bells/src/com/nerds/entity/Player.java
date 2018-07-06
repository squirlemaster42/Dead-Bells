package com.nerds.entity;

import com.nerds.utils.Handler;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    public Player(final Handler handler, final float x, final float y, final int width, final int height, final BufferedImage texture) {
        super(handler, x, y, width, height, texture);
    }

    @Override
    public void tick(){
        if(handler.getGame().getKeyManager().w) {
            yMove = -5;
        }
        else if(handler.getGame().getKeyManager().s){
            yMove = 5;
        }
        else{
            yMove = 0;
        }

        if(handler.getGame().getKeyManager().a){
            xMove = -5;
        }
        else if(handler.getGame().getKeyManager().d){
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
