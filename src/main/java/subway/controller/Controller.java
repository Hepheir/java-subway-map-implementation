package subway.controller;

import java.util.List;
import java.util.Optional;

import subway.command.Command;
import subway.command.CommandRepository;
import subway.enums.ScreenType;
import subway.exception.CommandNotFoundException;
import subway.io.Input;
import subway.view.View;

public class Controller {
    public static Optional<ScreenType> render(ScreenType screenType) {
        View.printScreenName(screenType.getValue());
        renderCommandsOutOf(screenType);
        return promptComandFrom(screenType).executeFrom(screenType);
    }

    public static Optional<ScreenType> back(ScreenType screenType) {
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> quit(ScreenType screenType) {
        return Optional.empty();
    }

    protected static int getInt() throws NumberFormatException {
        return Input.readInt();
    }

    protected static String getString() {
        return Input.readLine();
    }

    protected static Character getCharacter() {
        return Input.readChar();
    }

    private static void renderCommandsOutOf(ScreenType screenType) {
        CommandRepository.getCommandsOf(screenType).forEach(Controller::renderCommand);
    }

    private static Command promptComandFrom(ScreenType screenType) {
        Character key;
        List<Command> availableCommands = CommandRepository.getCommandsOf(screenType);
        Optional<Command> selectedCommand = Optional.empty();
        while (true) {
            View.printEmptyLine();
            View.printCommandPromptMessage();
            key = Input.readChar();
            View.printEmptyLine();
            selectedCommand = findCommandOutOf(availableCommands, key);
            if (selectedCommand.isPresent()) {
                return selectedCommand.get();
            }
            View.printError(new CommandNotFoundException().getMessage());
        }
    }

    private static void renderCommand(Command command) {
        View.printCommandFormat(command.getKey(), command.getDescription());
    }

    private static Optional<Command> findCommandOutOf(List<Command> availableCommands, Character key) {
        return availableCommands.stream()
            .filter(cmd -> cmd.getKey().equals(key))
            .findAny();
    }
}
