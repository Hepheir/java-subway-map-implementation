package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.model.Model;
import subway.view.View;

public class MainController {
    public static Optional<ScreenType> openStationManager(ScreenType parentScreenType) {
        return Optional.of(ScreenType.STATION_MANAGEMENT);
    }

    public static Optional<ScreenType> openLineManager(ScreenType parentScreenType) {
        return Optional.of(ScreenType.LINE_MANAGEMENT);
    }

    public static Optional<ScreenType> openSectionManager(ScreenType parentScreenType) {
        return Optional.of(ScreenType.SECTION_MANAGEMENT);
    }

    public static Optional<ScreenType> openSubwayMap(ScreenType parentScreenType) {
        View.printScreenName(parentScreenType.getValue());
        Model.getAllLineNames().forEach(lineName -> {
            View.printLineOfSubwayMap(lineName, (String[]) Model.getAllStationNamesOfLine(lineName).toArray());
            View.printEmptyLine();
        });
        return Optional.of(ScreenType.MAIN);
    }
}
