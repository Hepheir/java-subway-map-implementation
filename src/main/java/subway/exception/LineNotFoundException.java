package subway.exception;

public class LineNotFoundException extends IllegalArgumentException {
    public LineNotFoundException() {
        super("해당하는 노선이 존재하지 않습니다.");
    }
}
