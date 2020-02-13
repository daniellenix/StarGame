package com.example.cmpt276a3.model;

import java.util.Random;

public class CellManager {
    private static Random randomGenerator = new Random();

    private Cell[][] grid;
    private int[][] starGrid;
    private boolean[][] exploredCell;

    private int[] starInRow;
    private int[] starInColumn;

    private static CellManager instance;
    private Options data = Options.getInstance();

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

    //getters
    public Cell[][] getGrid() {
        return grid;
    }

    public int[] getStarInRow() {
        int row = data.getRow();
        return starInRow = new int[row];
    }

    public int[] getStarInColumn() {
        int column = data.getColumn();
        return starInColumn = new int[column];
    }

    public int[][] getStarGrid() {
        int row = data.getRow();
        int column = data.getColumn();
        return starGrid = new int[row][column];
    }

    // generating the stars randomly across grid
    private void generateStarsRandomly(){
        int row = data.getRow();
        int column = data.getColumn();

        int totalNumberOfCells = row*column;
        int totalNumberOfStars = data.getNumberOfStars();

        // random key from 0 to totalcells-1
        int key = randomGenerator.nextInt(totalNumberOfCells);

        int i = 0;
        if(i < totalNumberOfStars){
            for (int j = 0; j < row; j++){
                for (int k = 0; k < column; k++){
                    int makeStar = randomGenerator.nextInt(totalNumberOfCells);
                    if(makeStar == key){
                        int gridOfStars = starGrid[j][k];
                        starInRow[j]++;
                        starInColumn[k]++;
                        i++;
                    }
                    exploredCell[j][k]= false;
                }
            }
        }
    }

    // when change options-- generate the stars again randomly (may not need this actually)
    public void updateCells(){
        generateStarsRandomly();
    }

    // checks if have clicked on that cell before
    private boolean isExploredCell(int row, int column){
        return exploredCell[row][column];
    }

    // decrement total number of stars when user finds one
    public void updateNumberOfHiddenStarsOnceFound(int row, int column){
        exploredCell[row][column] = true;
        if(isExploredCell(row,column)){
            starInRow[row]--;
            starInColumn[column]--;
        }
    }


    public int getStars(int row, int column){
        return starGrid[row][column];
    }
}
