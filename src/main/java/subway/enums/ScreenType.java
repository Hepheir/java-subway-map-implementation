package subway.enums;

public enum ScreenType {
    MAIN("메인 화면"),
    STATION_MANAGEMENT("구간 관리 화면"),
    LINE_MANAGEMENT("노선 관리 화면"),
    SECTION_MANAGEMENT("구간 관리 화면"),
    SUBWAY_MAP("지하철 노선도");

    private final String value;

    ScreenType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
