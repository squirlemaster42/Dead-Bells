package com.nerds.entity;

import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {
    public Creature(float x, float y, int width, int height, BufferedImage texture) {
        super(x, y, width, height, texture);
    }
}
