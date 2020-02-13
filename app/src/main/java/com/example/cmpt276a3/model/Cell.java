package com.example.cmpt276a3.model;

public class Cell {
    private boolean hasMine;
    private int row;
    private int col;

    public Cell(boolean hasMine, int row, int col) {
        this.hasMine = hasMine;
        this.row = row;
        this.col = col;
    }
}
