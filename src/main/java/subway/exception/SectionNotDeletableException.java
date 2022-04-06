package subway.exception;

public class SectionNotDeletableException extends IllegalArgumentException {
    public SectionNotDeletableException() {
        super("구간을 삭제할 준비가 되지 않았습니다.");
    }
}
