package com.nerds.platforms;

import java.awt.*;

public class Platform {

    private Rectangle bounds;

    public Platform(int x, int y, int width, int height){
        bounds =  new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds(){
        return  bounds;
    }

    //Used to test platform locations
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public boolean contains(int x, int y){
        return bounds.contains(x, y);
    }
}
