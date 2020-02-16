package com.example.cmpt276a3.model;

import java.util.Random;

public class CellManager {

    private Cell[][] grid;

    private static final Cell STAR_NOT_CLICKED = new Cell(true, false);
    private static final Cell NO_STAR_NOT_CLICKED = new Cell(false, false);
    private static final Cell STAR_CLICKED = new Cell(true, true);
    private static final Cell NO_STAR_CLICKED = new Cell(false, true);

    private static Random randomGenerator = new Random();

    private int numberOfStarsFound;

    private static CellManager instance;
    private Options options = Options.getInstance();

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

    // generating the stars randomly across grid
    public void generateStarsRandomly(){

        numberOfStarsFound = 0;

        grid = new Cell[options.getRow()][options.getColumn()];
        int totalNumberOfStars = options.getNumberOfStars();

        for (int i = 0; i < options.getRow(); i++) {
            for (int j = 0; j < options.getColumn() ; j++) {
                grid[i][j] = NO_STAR_NOT_CLICKED;
            }
        }

        int starsPlaced = 0;

        while (starsPlaced < totalNumberOfStars) {
            int row = randomGenerator.nextInt(grid.length);
            int col = randomGenerator.nextInt(grid[row].length);
            if(grid[row][col] == NO_STAR_NOT_CLICKED) {
                grid[row][col] = STAR_NOT_CLICKED;
                starsPlaced++;
            }
        }
    }

    public boolean checkIfStar(int row, int col) {
        return grid[row][col] == STAR_NOT_CLICKED;
    }


    // when change options-- generate the stars again randomly (may not need this actually)
    public void updateCells(){
        generateStarsRandomly();
    }

    // checks if have clicked on that cell before
    private boolean isExploredCell(int row, int col){
        return grid[row][col] == STAR_CLICKED || grid[row][col] == NO_STAR_CLICKED;
    }

    // decrement total number of stars when user finds one
    public void updateNumberOfHiddenStarsOnceFound(int row, int column){
        for (int i = 0; i < options.getRow(); i++) {
            for (int j = 0; j < options.getColumn(); j++) {
                if(grid[i][j] == STAR_CLICKED) {
                    numberOfStarsFound--;
                }
            }
        }
    }

}
