package view.gui;

import controller.IController;
import utils.observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JGame extends JFrame implements IObserver, ActionListener {
    IController controller;
    private JCell[][] grid;
    JLabel statusJLabel;
    JTextField player1Field;
    JTextField player2Field;
    JPanel gamePanel;
    JPanel fieldsPanel;
    JPanel buttonPanel;
    JButton login;
    JButton restart;
    JButton quit;

    public JGame(IController controller) {
        this.controller = controller;
        this.statusJLabel = new JLabel(this.controller.getStatusMessage());
        this.grid = new JCell[this.controller.getGameSize()][this.controller.getGameSize()];

        /*
        This is the GAME Panel: Where we show our TicTacToe
         */
        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(400, 250));
        gamePanel.setLayout(new GridLayout(this.controller.getGameSize(), this.controller.getGameSize(), 2, 2));
        for (int i = 0; i < this.controller.getGameSize(); i++) {
            for (int j = 0; j < this.controller.getGameSize(); j++) {
                this.grid[i][j] = new JCell(i, j, this.controller.getICell(i, j));
                this.grid[i][j].addActionListener(this);
                gamePanel.add(this.grid[i][j]);
            }
        }
        gamePanel.setVisible(false);

        /*
        This is the Status Panel: Where we show our Messages
         */
        JPanel statusPanel = new JPanel();
        statusPanel.add(statusJLabel);



        /*
        This is the Fields Panel: Where we show The Input fields for setting the players names
         */
        fieldsPanel = new JPanel();
        fieldsPanel.setPreferredSize(new Dimension(400, 250));
        fieldsPanel.setLayout(new GridLayout(3, 2, 2, 2));
        player1Field = new JTextField();
        player2Field = new JTextField();
        login = new JButton("Submit");

        fieldsPanel.add(new JLabel("Player 1:"));
        fieldsPanel.add(player1Field);
        fieldsPanel.add(new JLabel("Player 2:"));
        fieldsPanel.add(player2Field);
        fieldsPanel.add(login);

        login.addActionListener(e -> {
            // Click Event
            String name1 = player1Field.getText();
            String name2 = player2Field.getText();
            controller.setPlayers(name1, name2);
        });


        /*
        This is the buttons Panel: Where we restart or quit the game after winning
         */
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 2, 2));
        restart = new JButton("restart Game");
        quit = new JButton("Quit");
        buttonPanel.add(restart);
        buttonPanel.add(quit);

        restart.addActionListener(e -> {
            this.controller.restartGame();
        });

        quit.addActionListener(e -> {
            System.exit(0);
        });
        buttonPanel.setVisible(false);


        /*
        This is the main Panel which we add the the JFrame
         */
        JPanel contentPanel = new JPanel();
        contentPanel.add(statusPanel);
        contentPanel.add(gamePanel);
        contentPanel.add(fieldsPanel);
        contentPanel.add(buttonPanel);

        this.add(contentPanel);
        this.setTitle("TicTacToe");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    @Override
    public void update() {
        for (int i = 0; i < this.controller.getGameSize(); i++) {
            for (int j = 0; j < this.controller.getGameSize(); j++) {
                this.grid[i][j].setText(this.controller.getICell(i, j).getValue());
                if (controller.userDidWin()) {
                    this.grid[i][j].setEnabled(false);
                } else if (this.controller.getICell(i, j).isSet()) {
                    this.grid[i][j].setEnabled(false);
                } else {
                    this.grid[i][j].setEnabled(true);
                }
            }
        }
        this.statusJLabel.setText(this.controller.getStatusMessage());

        fieldsPanel.setVisible(!this.controller.playersAreSet());
        gamePanel.setVisible(this.controller.playersAreSet());
        buttonPanel.setVisible(controller.userDidWin());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCell cellClicked = (JCell) e.getSource();
        this.controller.play(cellClicked.getI(), cellClicked.getJ());
    }
}
