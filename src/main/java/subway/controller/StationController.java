package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.View;

public class StationController extends Controller {
    public static Optional<ScreenType> addStation(ScreenType parentScreenType) {
        try {
            View.printHeader("등록할 역 이름을 입력하세요.");
            Model.createStation(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 역이 등록되었습니다.");
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteStation(ScreenType parentScreenType) {
        try {
            View.printHeader("삭제할 역 이름을 입력하세요.");
            Model.deleteStation(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 역이 삭제되었습니다.");
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listStation(ScreenType parentScreenType) {
        View.printHeader("역 목록");
        Model.getAllStationNames().forEach(View::printInfo);
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
