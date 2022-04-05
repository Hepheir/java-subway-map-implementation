package subway.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import subway.enums.ScreenType;
import subway.exception.CommandAlreadyExsitsException;

public class CommandRepository {
    private static final List<Command> commands = new ArrayList<>();

    public static List<Command> commands() {
        return Collections.unmodifiableList(commands);
    }

    public static void add(Command... commands) throws CommandAlreadyExsitsException {
        Arrays.asList(commands).forEach(CommandRepository::add);
    }

    public static List<Command> getCommandsOf(ScreenType screenTypes) {
        return commands().stream()
            .filter((cmd) -> cmd.getAllowedScreenTypes().contains(screenTypes))
            .collect(Collectors.toList());
    }

    // Helpers

    private static void add(Command command) throws CommandAlreadyExsitsException {
        checkAddable(command);
        commands.add(command);
    }

    private static void checkAddable(Command command) throws CommandAlreadyExsitsException {
        if (commands().stream().anyMatch(command::equals)) {
            throw new CommandAlreadyExsitsException();
        }
    }
}
