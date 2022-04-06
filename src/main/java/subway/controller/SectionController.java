package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.SectionEdit;
import subway.view.SectionView;
import subway.view.View;

public class SectionController extends Controller {
    public static Optional<ScreenType> addSection(ScreenType screenType) {
        SectionEdit sectionEdit = new SectionEdit();
        try {
            SectionView.askLineName();
            sectionEdit.setLine(Input.readLine());
            View.printEmptyLine();
            SectionView.askStationName();
            sectionEdit.setStation(Input.readLine());
            View.printEmptyLine();
            SectionView.askOrder();
            sectionEdit.setOrder(Input.readInt()-1);
            View.printEmptyLine();
            sectionEdit.add();
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

    public static Optional<ScreenType> deleteSection(ScreenType screenType) {
        SectionEdit sectionEdit = new SectionEdit();
        try {
            SectionView.askLineNameToDelete();
            sectionEdit.setLine(Input.readLine());
            View.printEmptyLine();
            SectionView.askStationNameToDelete();
            sectionEdit.setStation(Input.readLine());
            View.printEmptyLine();
            sectionEdit.delete();
            SectionView.printSectionDeletedSuccessfully();
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
