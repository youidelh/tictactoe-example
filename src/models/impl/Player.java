package models.impl;

import models.IPlayer;

public class Player implements IPlayer {
    String symbol;
    String name;

    public Player(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
