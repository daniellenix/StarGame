package com.example.cmpt276a3.model;

public class Cell {
    private int row;
    private int column;
    private boolean hasStar;

    public Cell(int row, int column, boolean hasStar) {
        this.row = row;
        this.column = column;
        this.hasStar = hasStar;
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

    public boolean isHasStar() {
        return hasStar;
    }

    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }
}
