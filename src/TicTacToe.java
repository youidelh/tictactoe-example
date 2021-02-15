import controller.Controller;
import models.Game;
import view.Tui;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        Controller controller = new Controller(game);
        Tui tui = new Tui(controller);
        /*System.out.println(controller.gameString());
        System.out.println(controller.getStatusMessage());
        controller.setPlayers("Aya0", "Marwa0");
        System.out.println(controller.getStatusMessage());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                controller.play(j, i);
                System.out.println(controller.gameString());
                System.out.println(controller.getStatusMessage());
            }
        }*/
        /*
        Aya: Interface
        Wissal: Abstract class
        Marwa: Java Scanner
         */
    }
}
