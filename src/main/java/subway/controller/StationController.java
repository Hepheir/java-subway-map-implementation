package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.StationView;
import subway.view.View;

public class StationController extends Controller {
    public static Optional<ScreenType> addStation(ScreenType screenType) {
        try {
            StationView.askStationNameToAdd();
            Model.createStation(Input.readLine());
            View.printEmptyLine();
            StationView.printStationAddedSuccessfully();
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteStation(ScreenType screenType) {
        try {
            StationView.askStationNameToDelete();
            Model.deleteStation(Input.readLine());
            View.printEmptyLine();
            StationView.printStationDeletedSuccessfully();
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listStation(ScreenType screenType) {
        StationView.printStationList();
        Model.getAllStationNames().forEach(View::printInfo);
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
