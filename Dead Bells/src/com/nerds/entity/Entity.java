package com.nerds.entity;

import java.awt.Graphics;

public abstract class Entity {

    public Entity(){

    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
