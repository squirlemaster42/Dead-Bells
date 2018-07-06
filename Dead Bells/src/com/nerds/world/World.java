package com.nerds.world;

import com.nerds.entity.Entity;
import com.nerds.entity.EntitySet;
import com.nerds.tile.Tile;
import com.nerds.utils.Utils;

import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;

public class World {

    private final EntitySet entitySet;
    private final Tile[][] tileArray;
    private final int[][] tileSet;
    private ArrayList<Entity> entities;

    public World(final String path){
        this.tileSet = loadTileSet(path);
        this.entitySet = null;
        this.tileArray = new Tile[tileSet.length][tileSet[0].length];
        entities = new ArrayList<>();
        init();
    }

    public World(final String path, final EntitySet entitySet){
        this.tileSet = loadTileSet(path);
        this.entitySet = entitySet;
        this.tileArray = new Tile[tileSet.length][tileSet[0].length];
        entities = new ArrayList<>();
        init();
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
            File filePath = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(filePath.getAbsoluteFile()));
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
        for(int x = 0; x < tileSet.length; x++){
            for(int i : tileSet[x]){
                try {
                    tileArray[x][i] = (Tile) Tile.getMapValue(tileSet[x][i]).newInstance();
                    tileArray[x][i].setXY(x * 64, i * 64);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Entity> getEntities(){
        return entities;
    }
}
