package controller.impl;

import controller.IController;
import models.ICell;
import models.IGame;
import models.IPlayer;
import models.impl.Messages;
import models.impl.Player;
import utils.observer.Observable;

public class Controller extends Observable implements IController {
    IGame game;
    boolean myTurn;
    IPlayer[] players;
    String statusMessage;

    public Controller(IGame game) {
        this.game = game;
        this.myTurn = true;
        this.players = new Player[2];
        this.statusMessage = Messages.WELCOME_MESSAGE;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String gameString () {
        return this.game.toString();
    }

    public boolean playersAreSet () {
        return this.players[0] != null && this.players[1] != null;
    }

    public int getGameSize () {
        return this.game.getSize();
    }
    public ICell getICell (int i, int j) {
        return this.game.getCell(i, j);
    }
    /**
     * Check if cell is set, otherwise set cell and change turn.
     * @param i Row index
     * @param j Column index
     */
    private void playInCell(int i, int j) {
        if (this.game.isCellSet(i, j)) {
            this.statusMessage = Messages.CELL_IS_SET;
        } else {
            this.game.setCell(this.players[this.myTurn ? 0 : 1].getSymbol() , i, j);
            this.statusMessage = Messages.PLAYER_CAN_PLAY(this.players[this.myTurn ? 0 : 1].getName(), this.players[this.myTurn ? 1 : 0].getName());
            // Player did play
            if (this.userDidWin()) {
                this.statusMessage = Messages.PLAYER_WON(this.players[this.myTurn ? 0 : 1].getName());
            }
            this.myTurn = !this.myTurn;
        }
        notifyObservers();
    }

    public void play (int i, int j) {
        if (this.playersAreSet()) { // kann spielen
            this.playInCell(i, j);
        } else {
            this.statusMessage = Messages.UNDEFINED_PLAYERS;
            notifyObservers();
        }
    }
    public void setPlayers (String name1, String name2) { // "Aya", "Marwa"
        this.players[0] = new Player("X", name1);
        this.players[1] = new Player("O", name2);
        this.statusMessage = Messages.PLAYERS_SET(name1);
        notifyObservers(); // ACHTUNG
    }


    private boolean userDidWin () {
        boolean win = false;

        for (int i = 0; i < this.game.getSize(); i++) {
            //this.game.getCell(0, 0).getValue() == this.game.getCell(0, 1).getValue() == this.game.getCell(0, 2).getValue();
            //this.game.getCell(1, 0).getValue() == this.game.getCell(1, 1).getValue() == this.game.getCell(1, 2).getValue();
            //this.game.getCell(2, 0).getValue() == this.game.getCell(2, 1).getValue() == this.game.getCell(2, 2).getValue();
            win = win || (this.game.isCellSet(i, 0))
                    && (this.game.getCell(i, 0).getValue() == this.game.getCell(i, 1).getValue())
                    && (this.game.getCell(i, 1).getValue() == this.game.getCell(i, 2).getValue());

            //this.game.getCell(0, 0).getValue() == this.game.getCell(1, 0).getValue() == this.game.getCell(2, 0).getValue();
            //this.game.getCell(0, 1).getValue() == this.game.getCell(1, 1).getValue() == this.game.getCell(2, 1).getValue();
            //this.game.getCell(0, 2).getValue() == this.game.getCell(1, 2).getValue() == this.game.getCell(2, 2).getValue();
            win = win || (this.game.isCellSet(0, i))
                    && (this.game.getCell(0, i).getValue() == this.game.getCell(1, i).getValue())
                    && (this.game.getCell(1, i).getValue() == this.game.getCell(2, i).getValue());
        }

        return win || userDidWinDiagonal();
    }

    private boolean userDidWinDiagonal () {
        boolean win = false;

        win = win || (this.game.isCellSet(0, 0))
                && (this.game.getCell(0, 0).getValue() == this.game.getCell(1, 1).getValue())
                && (this.game.getCell(1, 1).getValue() == this.game.getCell(2, 2).getValue());

        win = win || (this.game.isCellSet(0, 2))
                && (this.game.getCell(0, 2).getValue() == this.game.getCell(1, 1).getValue())
                && (this.game.getCell(1, 1).getValue() == this.game.getCell(2, 0).getValue());

        return win;
    }

    public void restartGame() {
        this.myTurn = true;
        this.game.restartGame();
        this.statusMessage = Messages.GAME_RESTARTED(this.players[0].getName());
        notifyObservers(); // ACHTUNG
    }
}
