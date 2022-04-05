package subway.domain;

public class Station {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final String name;

    public Station(String name) throws IllegalArgumentException {
        this.name = name;
        this.checkName();
    }

    public String getName() {
        return name;
    }

    private void checkName() throws IllegalArgumentException {
        if (this.name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }
}
