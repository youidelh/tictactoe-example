package view.gui;

import controller.IController;
import utils.observer.IObserver;

import javax.swing.*;
import java.awt.*;

public class JGame extends JFrame implements IObserver {
    IController controller;
    private JCell[][] grid;

    public JGame(IController controller) {
        this.controller = controller;

        grid = new JCell[this.controller.getGameSize()][this.controller.getGameSize()];

        for (int i = 0; i < this.controller.getGameSize(); i++) {
            for (int j = 0; j < this.controller.getGameSize(); j++) {
                this.grid[i][j] = new JCell(i, j, this.controller.getICell(i, j));
                this.add(this.grid[i][j]);
            }
        }
        this.setLayout(new GridLayout(this.controller.getGameSize(), this.controller.getGameSize(), 2, 2));
        this.setTitle("TicTacToe");
        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void update() {

    }
}
