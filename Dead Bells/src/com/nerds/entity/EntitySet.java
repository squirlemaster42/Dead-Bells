package com.nerds.entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntitySet {

    private final ArrayList<Entity> entityArray;

    public EntitySet(){
        entityArray = new ArrayList<>();
    }

    public void addEntity(Entity e){
        entityArray.add(e);
    }


    public void tick(){
        entityArray.forEach(Entity::tick);
    }

    public void render(Graphics g){
        entityArray.forEach(entity -> render(g));
    }
}
