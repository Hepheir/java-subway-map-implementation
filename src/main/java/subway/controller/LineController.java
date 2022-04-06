package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.LineView;
import subway.view.View;

public class LineController {
    public static Optional<ScreenType> addLine(ScreenType parentScreenType) {
        String newLineName;
        String[] newStationNames = new String[2];
        try {
            LineView.askLineNameToAdd();
            newLineName = Input.readLine();
            View.printEmptyLine();
            LineView.askUpperBoundStationNameToAdd();
            newStationNames[0] = Input.readLine();
            View.printEmptyLine();
            LineView.askLowerBoundStationNameToAdd();
            newStationNames[1] = Input.readLine();
            View.printEmptyLine();
            Model.createLine(newLineName, newStationNames);
            LineView.printLineAddedSuccessfully();
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteLine(ScreenType parentScreenType) {
        try {
            LineView.askLineNameToDelete();
            Model.deleteLine(Input.readLine());
            View.printEmptyLine();
            LineView.printLineDeletedSuccessfully();
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listLine(ScreenType parentScreenType) {
        LineView.printLineList();
        Model.getAllLineNames().forEach(View::printInfo);
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
