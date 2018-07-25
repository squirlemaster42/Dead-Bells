package com.nerds.entity;

import com.nerds.utils.Handler;

import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {

    protected float speed;
    protected float xMove, yMove;

    public Creature(final Handler handler, final float x, final float y, final int width, final int height, final BufferedImage texture) {
        super(handler, x, y, width, height, texture);
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        if(!checkEntityCollision(xMove, 0f, handler.getWorld().getEntities())){
            moveX();
        }

        if(!checkEntityCollision(0f, yMove, handler.getWorld().getEntities())) {
            moveY();
        }
    }

    public void moveX(){
        if(xMove > 0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;

            if(!collisionWithPlatform(tx, (int) (y + bounds.y) / 32) &&
                    !collisionWithPlatform(tx, (int) (y + bounds.y + bounds.height) / 32)){
                x += xMove;
            }else{
                x = tx * 32 - bounds.x - bounds.width - 1;
            }

        }else if(xMove < 0){//Moving left
            int tx = (int) (x + xMove + bounds.x) / 32;

            if(!collisionWithPlatform(tx, (int) (y + bounds.y) / 32) &&
                    !collisionWithPlatform(tx, (int) (y + bounds.y + bounds.height) / 32)){
                x += xMove;
            }else{
                x = tx * 32 + 32 - bounds.x;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//Up
            int ty = (int) (y + yMove + bounds.y) / 32;

            if(!collisionWithPlatform((int) (x + bounds.x) / 32, ty) &&
                    !collisionWithPlatform((int) (x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }else{
                y = ty * 32 + 32 - bounds.y;
            }

        }else if(yMove > 0){//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / 32;

            if(!collisionWithPlatform((int) (x + bounds.x) / 32, ty) &&
                    !collisionWithPlatform((int) (x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }else{
                y = ty * 32 - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithPlatform(int x, int y){
        return handler.getWorld().collisionWithPlatform(x, y);
    }

    //Getters and setters
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
