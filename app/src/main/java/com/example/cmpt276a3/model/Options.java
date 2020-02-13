package com.example.cmpt276a3.model;

public class Options {
    private int row;
    private int column;
    private int numberOfStars;

    private static Options instance;

    public static Options getInstance() {
        if(instance == null) {
            instance = new Options();
        }
        return instance;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}
