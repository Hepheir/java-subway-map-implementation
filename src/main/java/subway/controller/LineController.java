package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.LineEdit;
import subway.model.Model;
import subway.view.LineView;
import subway.view.View;

public class LineController {
    public static Optional<ScreenType> addLine(ScreenType screenType) {
        LineEdit lineEdit = new LineEdit();
        try {
            LineView.askLineNameToAdd();
            lineEdit.setLineName(Input.readLine());
            View.printEmptyLine();
            LineView.askUpperBoundStationNameToAdd();
            lineEdit.setUpperBoundStationName(Input.readLine());
            View.printEmptyLine();
            LineView.askLowerBoundStationNameToAdd();
            lineEdit.setLowerBoundStationName(Input.readLine());
            View.printEmptyLine();
            lineEdit.add();
            LineView.printLineAddedSuccessfully();
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteLine(ScreenType screenType) {
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

    public static Optional<ScreenType> listLine(ScreenType screenType) {
        LineView.printLineList();
        Model.getAllLineNames().forEach(View::printInfo);
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
