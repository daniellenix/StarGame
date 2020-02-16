package com.example.cmpt276a3.model;

public class Cell {
    private boolean hasStar;
    private boolean hasClicked;

    public Cell(boolean hasStar, boolean  hasClicked) {
        this.hasStar = hasStar;
        this.hasClicked = hasClicked;
    }

    public boolean isHasStar() {
        return hasStar;
    }

    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }
}
