package com.example.cmpt276a3.model;

public class Cell {
    private int row;
    private int column;
    private int stars[][];
    private boolean exploredCell[][];
    private boolean isStars[][];

    Cell(int row, int column){
        this.row = 0;
        this.column = 0;
        stars[row][column]=0;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    //checks if star is in particular cell
    public boolean isStars(int row, int column){
        return isStars[row][column];
    }

    //checks if cell already explored
    public boolean getExploredCells(int row, int column){
        return exploredCell[row][column];

    }


    public void e(int row, int column){
        exploredCell[row][column] = true;
        if(isStars(row,column)){
            stars[row][column] = stars[row-1][column-1];
        }
    }

}
