package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.model.Model;
import subway.view.MainView;

public class MainController extends Controller {
    public static Optional<ScreenType> openStationManager(ScreenType screenType) {
        return Optional.of(ScreenType.STATION_MANAGEMENT);
    }

    public static Optional<ScreenType> openLineManager(ScreenType screenType) {
        return Optional.of(ScreenType.LINE_MANAGEMENT);
    }

    public static Optional<ScreenType> openSectionManager(ScreenType screenType) {
        return Optional.of(ScreenType.SECTION_MANAGEMENT);
    }

    public static Optional<ScreenType> openSubwayMap(ScreenType screenType) {
        MainView.printSubwayMapTitle();
        Model.getAllLineNames().forEach(lineName -> {
            MainView.printLineName(lineName);
            MainView.printLineAndStationsSeperator();
            Model.getAllStationNamesOfLine(lineName)
                .forEach(MainView::printStationName);
            MainView.printEmptyLine();
        });
        return Optional.of(ScreenType.MAIN);
    }
}
