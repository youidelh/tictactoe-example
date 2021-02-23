import controller.impl.Controller;
import controller.IController;
import models.impl.Game;
import models.IGame;
import view.gui.JGame;
import view.Tui;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        IGame game = new Game();
        IController controller = new Controller(game);
        Tui tui = new Tui(controller);
        JGame gui = new JGame(controller);

        controller.addObserver(tui); // ACHTUNG
        controller.addObserver(gui); // ACHTUNG

        Scanner scanner = new Scanner(System.in);
        boolean isOver = false;

        while (!isOver) {
            String input = scanner.next();
            isOver = tui.processInput(input);
        }
    }
}
