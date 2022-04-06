package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.SectionView;
import subway.view.View;

public class SectionController extends Controller {
    public static Optional<ScreenType> addSection(ScreenType parentScreenType) {
        String lineName;
        String stationName;
        int index;
        try {
            SectionView.askLineName();
            lineName = Input.readLine();
            View.printEmptyLine();
            SectionView.askStationName();
            stationName = Input.readLine();
            View.printEmptyLine();
            SectionView.askOrder();
            index = Input.readInt();
            View.printEmptyLine();
            Model.addSection(lineName, stationName, index);
            SectionView.printSectionAddedSuccessfully();
        } catch (NumberFormatException e) {
            View.printEmptyLine();
            SectionView.printErrorNotANumber();
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteSection(ScreenType parentScreenType) {
        String lineName;
        String stationName;
        try {
            SectionView.askLineNameToDelete();
            lineName = Input.readLine();
            View.printEmptyLine();
            SectionView.askStationNameToDelete();
            stationName = Input.readLine();
            View.printEmptyLine();
            Model.deleteSection(lineName, stationName);
            SectionView.printSectionDeletedSuccessfully();
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
