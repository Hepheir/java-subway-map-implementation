package subway.controller;

import java.util.List;

import subway.command.Command;
import subway.command.CommandRepository;
import subway.io.Input;
import subway.view.View;

public class Controller {
    private final String label;
    protected final CommandRepository commandRepository = new CommandRepository();

    public Controller(String label) {
        this.label = label;
    }

    public final String getLabel() {
        return this.label;
    }

    public final List<Command> commands() {
        return commandRepository.commands();
    }

    private final void promptAction() {
        boolean didCommandExecute = false;
        Command selectedCommand;
        do {
            try {
                View.renderCommandGuide();
                selectedCommand = promptCommand();
                View.printEmptyLine();

                selectedCommand.execute();
                didCommandExecute = true;
            } catch (IllegalArgumentException e) {
                View.printEmptyLine();
                View.printError(e.getMessage());
                View.printEmptyLine();
            }
        } while (!didCommandExecute);
    }

    private final Command promptCommand() throws IllegalArgumentException {
        return commandRepository.getCommand(Input.readChar());
    }

    public final void render() {
        View.renderController(this);
        this.promptAction();
    }
}
