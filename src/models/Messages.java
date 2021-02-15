package models;

public class Messages {
    public static final String WELCOME_MESSAGE = "Welcome to tictactoe, you may now give the names of the player separated by -";
    public static final String CELL_IS_SET = "Cell is set, please choose another one";
    public static final String UNDEFINED_PLAYERS = "Players are undefined, please set Players";
    public static final String PLAYER_WON = "Someone has won";

    public static String PLAYERS_SET(String name1) {
        return "Thank you for setting the players, " + name1 + " you may play now";
    }

    public static String PLAYER_CAN_PLAY(String name, String name1) {
        return name + " thank you for playing, " + name1 + " you may play now";
    }
}
