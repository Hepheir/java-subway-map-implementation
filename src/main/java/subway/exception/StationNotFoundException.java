package subway.exception;

public class StationNotFoundException extends IllegalArgumentException {
    public StationNotFoundException() {
        super("해당하는 역이 존재하지 않습니다.");
    }
}
