package models;

public interface IGame {
    public boolean isCellSet (int i, int j);
    public void setCell (String value, int i, int j);
    public void restartGame();
    public ICell getCell (int i, int j);
    public int getSize ();
}
