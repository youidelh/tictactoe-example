package view;

import controller.Controller;
import utils.observer.IObserver;

public class Tui implements IObserver {
    Controller controller;

    public Tui(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println(controller.gameString());
        System.out.println(controller.getStatusMessage());
    }
}
