package subway.exception;

public class CommandAlreadyExsitsException extends IllegalArgumentException {
    public CommandAlreadyExsitsException() {
        super("이미 등록된 명령입니다.");
    }
}
