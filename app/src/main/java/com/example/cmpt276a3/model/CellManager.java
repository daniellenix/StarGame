package com.example.cmpt276a3.model;

import java.util.Random;

public class CellManager {
    private static Random randomGenerator = new Random();

    private Cell[][] grid;
    private int starInRow;
    private int starInColumn;

    private static CellManager instance;

    //Singleton Class
    private CellManager(){
        generateStarsRandomly();
    }

    public static CellManager getInstance() {
        if(instance == null) {
            instance = new CellManager();
        }
        return instance;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    private void updateCell(){
        generateStarsRandomly();
    }

    private void generateStarsRandomly(){
        boolean isStarInCell = false;

        while(!isStarInCell){

        }
    }


}
