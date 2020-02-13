package com.example.cmpt276a3.model;

public class Options {
    private int row;
    private int col;
    private int numberOfStars;
    private static Options instance;

    Options(int row, int column){


    }

    public static Options getInstance() {
        return instance;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfStars = numberOfMines;
    }
}
