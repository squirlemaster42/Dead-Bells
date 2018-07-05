package com.nerds.world;

import com.nerds.entity.Entity;
import com.nerds.entity.EntitySet;
import com.nerds.tile.Tile;
import com.nerds.utils.Utils;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class World {

    private final EntitySet entitySet;
    private final Tile[][] tileArray;
    private final int[][] tileSet;
    private ArrayList<Entity> entities;

    public World(final String path){
        this.tileSet = loadTileSet(path);
        this.entitySet = null;
        this.tileArray = new Tile[1][1];
        entities = new ArrayList<>();
    }

    public World(final String path, final EntitySet entitySet){
        this.tileSet = loadTileSet(path);
        this.entitySet = entitySet;
        this.tileArray = new Tile[1][1];
        entities = new ArrayList<>();
    }

    public void tick(){
        if(entitySet != null){
            entitySet.tick();
        }

        entities.forEach(Entity::tick);
    }

    public void render(Graphics g){
        if(entitySet != null){
            entitySet.render(g);
        }
        entities.forEach(entity -> render(g));
    }

    public Tile getTile(final int x, final int y){
        return null;
    }

    private int[][] loadTileSet(final String path){
        int[][] file;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String[] firstLine = br.readLine().split(" ");
            file = new int[Utils.parseInt(firstLine[0])][Utils.parseInt(firstLine[1])];

            int index = 0;
            String line;
            while((line = br.readLine()) != null){
                String[] section = line.split(" ");
                for(int i = 0; i < file[0].length; i++){
                    file[index][i] = Utils.parseInt(section[i]);
                }
                index++;
            }

            br.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(path);
            return null;
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return file;
    }

    private void init(){
        
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }
}
