package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum ScreenType {
    MAIN("메인 화면"),
    STATION_MANAGEMENT("구간 관리 화면"),
    LINE_MANAGEMENT("노선 관리 화면"),
    SECTION_MANAGEMENT("구간 관리 화면"),
    SUBWAY_MAP("지하철 노선도");

    private final String value;

    public static ScreenType[] valuesExcept(ScreenType... excludedScreenTypes) {
        List<ScreenType> excludedScreenTypeList = Arrays.asList(excludedScreenTypes);
        return Arrays.asList(ScreenType.values()).stream()
            .filter(screenType -> !excludedScreenTypeList.contains(screenType))
            .toArray(ScreenType[]::new);
    }

    ScreenType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
