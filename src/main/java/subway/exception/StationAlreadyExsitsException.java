package subway.exception;

public class StationAlreadyExsitsException extends IllegalArgumentException {
    public StationAlreadyExsitsException() {
        super("이미 등록된 역 이름입니다.");
    }
}
