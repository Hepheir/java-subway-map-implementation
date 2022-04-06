package subway.exception;

public class LineNotAddableException extends IllegalArgumentException {
    public LineNotAddableException() {
        super("노선을 생성할 준비가 되지 않았습니다.");
    }
}
