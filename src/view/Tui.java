package view;

import controller.IController;
import utils.observer.IObserver;

public class Tui implements IObserver {
    IController controller;

    public Tui(IController controller) {
        this.controller = controller;
        this.printGame();
    }

    public void printGame() {
        System.out.println(controller.gameString());
        System.out.println(controller.getStatusMessage());
    }

    @Override
    public void update() {
        this.printGame();
    }

    public boolean processInput(String input) {
        switch (input) {
            case "r":
                this.controller.restartGame();
                break;
            case "q":
                return true;
            default:
                handleInput(input);
        }
        return false;
    }

    private void handleInput(String input) {
        /*
        aya-marwa --> setPlayer
        00 -->
         */
        if (!this.controller.playersAreSet()) {
            // bsp. aya-marwa
            String[] names = input.split("-"); // bsp. {"aya", "marwa"}
            this.controller.setPlayers(names[0], names[1]);
        } else {
            // bsp. 02
            String[] moves = input.split(""); // bsp. {"0", "2"}
            this.controller.play(Integer.parseInt(moves[0]), Integer.parseInt(moves[1]));
        }
    }
}
