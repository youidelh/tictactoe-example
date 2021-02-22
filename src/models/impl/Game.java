package models.impl;

import models.ICell;
import models.IGame;

public class Game implements IGame {
    private ICell[][] grid;
    int size = 3;
    public Game () {
        this.grid = new ICell[size][size];
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }
    public int getSize () {
        return size;
    }
    public boolean isCellSet (int i, int j) {
        return this.grid[i][j].isSet();
    }

    public ICell getCell (int i, int j) {
        return this.grid[i][j];
    }

    public void setCell (String value, int i, int j) {
        this.grid[i][j].setValue(value);
    }

    public ICell[][] getCells() {
        return this.grid;
    }
    public String toString () { // \n --> new line , " " --> space, jede Cell ---
        String result = "/-----------\\       infos\n";
        for (int i = 0; i < this.grid.length; i++) {
            result += "|";
            for (int j = 0; j < this.grid[i].length; j++) {
                String value = this.grid[i][j].isSet() ? this.grid[i][j].getValue() : "-";
                result += "-" + value + "-";
                result += "|";
            }
            result += "    |";
            for (int k = 0; k < this.grid[i].length; k++) {
                result += i  + "" + k;
                result += "|";
            }
            result += "\n";
        }
        result+= "-------------";
        return result;
    }

    public void restartGame() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }
}
