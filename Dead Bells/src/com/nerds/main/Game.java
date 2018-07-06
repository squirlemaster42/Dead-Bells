package com.nerds.main;

import com.nerds.graphics.Assets;
import com.nerds.graphics.Screen;
import com.nerds.input.KeyManager;
import com.nerds.input.MouseManager;
import com.nerds.states.GameState;
import com.nerds.states.MainMenuState;
import com.nerds.states.State;
import com.nerds.tile.Tile;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Screen screen;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private Thread thread;
    private final Dimension screenSize;
    private final KeyManager keyManager;
    private final MouseManager mouseManager;

    //States
    private State mainMenu;
    private State gameState;

    public Game(final Dimension screenSize){
        this.screenSize = screenSize;

        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){
        screen = new Screen(screenSize);
        screen.getFrame().addKeyListener(keyManager);
        screen.getFrame().addMouseListener(mouseManager);
        screen.getFrame().addMouseMotionListener(mouseManager);
        screen.getCanvas().addMouseListener(mouseManager);
        screen.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();
        Tile.initTileMap();

        mainMenu = new MainMenuState();
        gameState = new GameState();
        State.setState(gameState);
    }

    public void tick(){
        keyManager.tick();

        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }

    public void render(){
        bs = screen.getCanvas().getBufferStrategy();

        if(bs == null){
            screen.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
        }

        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println(ticks);
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }

    public synchronized void start(){
        if(running)return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
