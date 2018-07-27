package com.nerds.entity;

import com.nerds.graphics.Assets;
import com.nerds.utils.Handler;

import java.awt.Graphics;

public class Player extends Entity {

    private int xMove = 0;
    private int yMove = 0;

    public Player(Handler handler, int x, int y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
        moveX();
        moveY();
    }

    private void moveX(){
        if(xMove > 0){ //Moving Right
            if(!getHandler().getWorld().checkPlatformCollision(bounds.x, bounds.y)){

            }
        }else if(xMove < 0){//Moving Left

        }
    }

    private void moveY(){
        if(yMove < 0){ //Moving Right

        }else if(yMove > 0){//Moving Left

        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, bounds.x, bounds.y, bounds.width, bounds.height, null);
    }
}
