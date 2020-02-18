package com.example.cmpt276a3.model;

public class Cell {
    private boolean hasStar;
    private boolean hasClicked;
    private boolean hasScanned;

    public Cell(boolean hasStar, boolean  hasClicked, boolean  hasScanned) {
        this.hasStar = hasStar;
        this.hasClicked = hasClicked;
        this.hasScanned = hasScanned;
    }

    public boolean isHasStar() {
        return hasStar;
    }

    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }
}
