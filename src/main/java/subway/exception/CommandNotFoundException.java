package subway.exception;

public class CommandNotFoundException extends IllegalArgumentException {
    public CommandNotFoundException() {
        super("선택할 수 없는 기능입니다.");
    }
}
