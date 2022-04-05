package subway;

import java.util.Stack;

import subway.controller.Controller;
import subway.controller.MainController;

public class Client {
    private static Stack<Controller> contollerStack = new Stack<>();

    public static void run() {
        Client.open(new MainController());
        while (!contollerStack.isEmpty()) {
            contollerStack.peek().render();
        };
    }

    public static void open(Controller controller) {
        contollerStack.add(controller);
    }

    public static void goBack() {
        contollerStack.pop();
    }

    public static void close() {
        contollerStack.clear();
    }
}
