package subway.exception;

public class LineAlreadyExsitsException extends IllegalArgumentException {
    public LineAlreadyExsitsException() {
        super("이미 등록된 노선 이름입니다.");
    }
}
