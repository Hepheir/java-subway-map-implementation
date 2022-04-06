package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.model.LineEdit;
import subway.model.Model;
import subway.view.LineView;

public class LineController extends Controller {
    public static Optional<ScreenType> addLine(ScreenType screenType) {
        LineEdit lineEdit = new LineEdit();
        try {
            LineView.askLineNameToAdd();
            lineEdit.setLineName(getString());
            LineView.printEmptyLine();
            LineView.askUpperBoundStationNameToAdd();
            lineEdit.setUpperBoundStationName(getString());
            LineView.printEmptyLine();
            LineView.askLowerBoundStationNameToAdd();
            lineEdit.setLowerBoundStationName(getString());
            LineView.printEmptyLine();
            lineEdit.add();
            LineView.printLineAddedSuccessfully();
        } catch (IllegalArgumentException e) {
            LineView.printEmptyLine();
            LineView.printError(e.getMessage());
        }
        LineView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteLine(ScreenType screenType) {
        try {
            LineView.askLineNameToDelete();
            Model.deleteLine(getString());
            LineView.printEmptyLine();
            LineView.printLineDeletedSuccessfully();
        } catch (Exception e) {
            LineView.printEmptyLine();
            LineView.printError(e.getMessage());
        }
        LineView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listLine(ScreenType screenType) {
        LineView.printLineList();
        Model.getAllLineNames().forEach(LineView::printInfo);
        LineView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
