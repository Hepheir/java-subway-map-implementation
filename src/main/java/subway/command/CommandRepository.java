package subway.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandRepository {
    private final List<Command> commands = new ArrayList<>();

    public Command getCommand(Character key) throws IllegalArgumentException {
        Optional<Command> foundCommand = this.commands().stream()
            .filter(command -> command.getKey().equals(key)).findFirst();
        if (!foundCommand.isPresent()) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
        return foundCommand.get();
    }

    public Command createCommand(Character key, String label, Runnable action) {
        return new Command(this, key, label, action);
    }

    public List<Command> commands() {
        return Collections.unmodifiableList(commands);
    }

    protected void addCommand(Command command) {
        commands.add(command);
    }

    protected void deleteCommand(Command command) {
        commands.remove(command);
    }

    protected boolean hasCommand(Command command) {
        return commands.stream().map(Command::getKey).collect(Collectors.toList()).contains(command.getKey());
    }
}
