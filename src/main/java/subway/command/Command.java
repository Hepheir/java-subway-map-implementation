package subway.command;

public class Command {
    private Character key;
    private String label;
    private Runnable action;
    private CommandRepository repository;

    protected Command(CommandRepository repository, Character key, String label, Runnable action) {
        this.key = key;
        this.label = label;
        this.action = action;
        this.repository = repository;

        this.checkDuplicate();
        repository.addCommand(this);
    }

    public String getLabel() {
        return this.label;
    }

    public Character getKey() {
        return this.key;
    }

    public void execute() {
        this.action.run();
    }

    private void checkDuplicate() throws IllegalArgumentException {
        if (this.repository.hasCommand(this)) {
            throw new IllegalArgumentException("해당 키바인드가 이미 사용중입니다.");
        }
    }
}
