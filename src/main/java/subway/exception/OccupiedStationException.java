package subway.exception;

public class OccupiedStationException extends IllegalArgumentException {
    public OccupiedStationException() {
        super("노선에 등록되어 있는 역입니다.");
    }
}
