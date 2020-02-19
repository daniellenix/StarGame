package com.example.cmpt276a3.model;

import java.util.Random;

/**
 * Provides foundation for game grid.
 */
public class CellManager {

    private Cell[][] grid;

    private static final Cell STAR_NOT_CLICKED = new Cell(true, false, false);
    private static final Cell NO_STAR_NOT_CLICKED = new Cell(false, false, false);
    private static final Cell STAR_CLICKED = new Cell(true, true, false);
    private static final Cell NO_STAR_CLICKED = new Cell(false, true, false);
    private static final Cell STAR_SCANNED = new Cell(true, true, true);

    private static Random randomGenerator = new Random();

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

    // Places stars throughout the board
    public void generateStarsRandomly(){

        grid = new Cell[options.getRow()][options.getColumn()];
        int totalNumberOfStars = options.getNumberOfStars();

        // initialize the board to all empty cells, that have not been explored
        for (int i = 0; i < options.getRow(); i++) {
            for (int j = 0; j < options.getColumn() ; j++) {
                grid[i][j] = NO_STAR_NOT_CLICKED;
            }
        }

        int starsPlaced = 0;

        // randomly puts stars on board
        while (starsPlaced < totalNumberOfStars) {
            int row = randomGenerator.nextInt(grid.length);
            int col = randomGenerator.nextInt(grid[row].length);
            if(grid[row][col] == NO_STAR_NOT_CLICKED) {
                grid[row][col] = STAR_NOT_CLICKED;
                starsPlaced++;
            }
        }
    }

    public boolean hasStarScanned(int row, int col) {
        return grid[row][col] == STAR_SCANNED;
    }

    public boolean hasStarNotClicked(int row, int col) {
        return grid[row][col] == STAR_NOT_CLICKED;
    }

    public boolean hasStarAndClicked(int row, int col) {
        return grid[row][col] == STAR_CLICKED;
    }

    public boolean noStarNotClicked(int row, int col) {
        return grid[row][col] == NO_STAR_NOT_CLICKED;
    }

    public boolean noStarAndClicked(int row, int col) {
        return grid[row][col] == NO_STAR_CLICKED;
    }

    public void markStarClicked(int row, int col) {
        grid[row][col] = STAR_CLICKED;

    }

    public void markNoStarClicked(int row, int col) {
        grid[row][col] = NO_STAR_CLICKED;

    }

    public void markStarScanned(int row, int col) {
        grid[row][col] = STAR_SCANNED;
    }

    // scans row and column for any stars that haven't been found
    public int scanRowAndCol(int row, int col) {
        int starCounter = 0;

        for (int i = 0; i < options.getRow(); i++) {
            if(grid[i][col] == STAR_NOT_CLICKED) {
                starCounter++;
            }
        }

        for (int i = 0; i < options.getColumn(); i++) {
            if(grid[row][i] == STAR_NOT_CLICKED) {
                starCounter++;
            }
        }
        return starCounter;
    }
}
