package view.gui;

import models.ICell;

import javax.swing.*;

public class JCell extends JButton {
    int i;
    int j;
    public JCell(int i, int j, ICell cell) {
        this.i = i;
        this.j = j;
        this.setText(cell.getValue());
    }

    public void setValue (ICell cell){
        this.setText(cell.getValue());
    }


    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
