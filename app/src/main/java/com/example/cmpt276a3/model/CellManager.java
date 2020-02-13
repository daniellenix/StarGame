package com.example.cmpt276a3.model;

import java.util.Random;

public class CellManager {
    private static Random randomGenerator = new Random();
    private Cell[][] grid;
    private int starInRow;
    private int starInColumn;
    private Options data = Options.getInstance();

    //Singleton Class
    private CellManager(){
        generateStarsRandomly();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    private void updateCell(){
        generateStarsRandomly();
    }

    private void generateStarsRandomly(){
        boolean isStarInCell = false;

        int row = data.getRow();
        int column = data.getCol();
        int totalNumberOfCells = row*column;

        int index = randomGenerator.nextInt(totalNumberOfCells);

        while(!isStarInCell){




        }
    }


}
