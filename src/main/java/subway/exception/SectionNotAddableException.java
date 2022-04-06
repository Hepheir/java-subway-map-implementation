package subway.exception;

public class SectionNotAddableException extends IllegalArgumentException {
    public SectionNotAddableException() {
        super("구간을 등록할 준비가 되지 않았습니다.");
    }
}
