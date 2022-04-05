package subway.exception;

public class InvalidStationNameException extends IllegalArgumentException {
    public InvalidStationNameException() {
        super("지하철 역 이름은 2글자 이상이어야 합니다.");
    }
}
