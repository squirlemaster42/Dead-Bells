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
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}
