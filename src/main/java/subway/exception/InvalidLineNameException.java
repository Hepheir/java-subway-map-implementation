package subway.exception;

public class InvalidLineNameException extends IllegalArgumentException {
    public InvalidLineNameException() {
        super("지하철 노선 이름은 2글자 이상이어야 합니다.");
    }
}
