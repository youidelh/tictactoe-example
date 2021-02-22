package controller;

import utils.observer.IObserver;

public interface IController {
    public String getStatusMessage();
    public String gameString ();
    public boolean playersAreSet ();
    public void play (int i, int j);
    public void setPlayers (String name1, String name2);
    public void restartGame();
    public void addObserver(IObserver s);
}
