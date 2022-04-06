package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.model.Model;
import subway.view.StationView;

public class StationController extends Controller {
    public static Optional<ScreenType> addStation(ScreenType screenType) {
        try {
            StationView.askStationNameToAdd();
            Model.createStation(getString());
            StationView.printEmptyLine();
            StationView.printStationAddedSuccessfully();
        } catch (Exception e) {
            StationView.printEmptyLine();
            StationView.printError(e.getMessage());
        }
        StationView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteStation(ScreenType screenType) {
        try {
            StationView.askStationNameToDelete();
            Model.deleteStation(getString());
            StationView.printEmptyLine();
            StationView.printStationDeletedSuccessfully();
        } catch (Exception e) {
            StationView.printEmptyLine();
            StationView.printError(e.getMessage());
        }
        StationView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listStation(ScreenType screenType) {
        StationView.printStationList();
        Model.getAllStationNames().forEach(StationView::printInfo);
        StationView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
