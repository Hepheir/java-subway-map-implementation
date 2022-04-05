package subway;

import java.util.Optional;

import subway.controller.Controller;
import subway.enums.ScreenType;

public class Client {
    public static void run() {
        Optional<ScreenType> nextScreen = Optional.of(ScreenType.MAIN);

        while (nextScreen.isPresent()) {
            nextScreen = Controller.render(nextScreen.get());
        }
    }
}
