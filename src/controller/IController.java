package controller;

import models.ICell;
import utils.observer.IObserver;

public interface IController {
    public String getStatusMessage();
    public String gameString ();
    public boolean playersAreSet ();
    public void play (int i, int j);
    public void setPlayers (String name1, String name2);
    public void restartGame();
    public void addObserver(IObserver s);
    public int getGameSize ();
    public ICell getICell (int i, int j);
    public boolean userDidWin ();
}
