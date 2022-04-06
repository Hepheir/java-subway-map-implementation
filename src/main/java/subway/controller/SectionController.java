package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.SectionEdit;
import subway.view.SectionView;

public class SectionController extends Controller {
    public static Optional<ScreenType> addSection(ScreenType screenType) {
        SectionEdit sectionEdit = new SectionEdit();
        try {
            SectionView.askLineName();
            sectionEdit.setLine(Input.readLine());
            SectionView.printEmptyLine();
            SectionView.askStationName();
            sectionEdit.setStation(Input.readLine());
            SectionView.printEmptyLine();
            SectionView.askOrder();
            sectionEdit.setOrder(Input.readInt()-1);
            SectionView.printEmptyLine();
            sectionEdit.add();
            SectionView.printSectionAddedSuccessfully();
        } catch (NumberFormatException e) {
            SectionView.printEmptyLine();
            SectionView.printErrorNotANumber();
        } catch (IllegalArgumentException e) {
            SectionView.printEmptyLine();
            SectionView.printError(e.getMessage());
        }
        SectionView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteSection(ScreenType screenType) {
        SectionEdit sectionEdit = new SectionEdit();
        try {
            SectionView.askLineNameToDelete();
            sectionEdit.setLine(Input.readLine());
            SectionView.printEmptyLine();
            SectionView.askStationNameToDelete();
            sectionEdit.setStation(Input.readLine());
            SectionView.printEmptyLine();
            sectionEdit.delete();
            SectionView.printSectionDeletedSuccessfully();
        } catch (IllegalArgumentException e) {
            SectionView.printEmptyLine();
            SectionView.printError(e.getMessage());
        }
        SectionView.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
