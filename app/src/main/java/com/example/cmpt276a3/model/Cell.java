package com.example.cmpt276a3.model;

/**
 * Represents each cell in the board, checks if it has a star, if its been clicked or scanned.
 */
public class Cell {
    private boolean hasStar;
    private boolean hasClicked;
    private boolean hasScanned;

    public Cell(boolean hasStar, boolean hasClicked, boolean hasScanned) {
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

    public boolean isHasClicked() {
        return hasClicked;
    }

    public void setHasClicked(boolean hasClicked) {
        this.hasClicked = hasClicked;
    }

    public boolean isHasScanned() {
        return hasScanned;
    }

    public void setHasScanned(boolean hasScanned) {
        this.hasScanned = hasScanned;
    }
}
