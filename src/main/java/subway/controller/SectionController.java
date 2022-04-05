package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.View;

public class SectionController extends Controller {
    public static Optional<ScreenType> addSection(ScreenType parentScreenType) {
        String lineName;
        String stationName;
        int index;
        try {
            View.printHeader("노선을 입력하세요.");
            lineName = Input.readLine();
            View.printEmptyLine();

            View.printHeader("역이름을 입력하세요.");
            stationName = Input.readLine();
            View.printEmptyLine();

            View.printHeader("순서를 입력하세요.");
            index = Input.readInt();
            View.printEmptyLine();

            Model.addSection(lineName, stationName, index);
            View.printInfo("구간이 등록되었습니다.");
        } catch (NumberFormatException e) {
            View.printEmptyLine();
            View.printError("숫자가 아닙니다.");
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
            View.printHeader("삭제할 구간의 노선을 입력하세요.");
            lineName = Input.readLine();
            View.printEmptyLine();

            View.printHeader("삭제할 구간의 역을 입력하세요.");
            stationName = Input.readLine();
            View.printEmptyLine();

            Model.deleteSection(lineName, stationName);
            View.printInfo("지하철 역이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
