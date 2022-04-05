package subway.exception;

public class NotEnoughStationsException extends IllegalArgumentException {
    public NotEnoughStationsException() {
        super("노선에는 두 개 이상의 역이 포함되어야 합니다.");
    }
}
