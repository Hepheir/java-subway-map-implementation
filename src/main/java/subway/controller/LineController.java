package subway.controller;

import java.util.Optional;

import subway.enums.ScreenType;
import subway.io.Input;
import subway.model.Model;
import subway.view.View;

public class LineController {
    public static Optional<ScreenType> addLine(ScreenType parentScreenType) {
        String newLineName;
        String[] newStationNames = new String[2];
        try {
            View.printHeader("등록할 노선 이름을 입력하세요.");
            newLineName = Input.readLine();
            View.printEmptyLine();

            View.printHeader("등록할 노선 상행 종점역 이름을 입력하세요.");
            newStationNames[0] = Input.readLine();
            View.printEmptyLine();

            View.printHeader("등록할 노선 하행 종점역 이름을 입력하세요.");
            newStationNames[1] = Input.readLine();
            View.printEmptyLine();

            Model.createLine(newLineName, newStationNames);
            View.printInfo("지하철 노선이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> deleteLine(ScreenType parentScreenType) {
        try {
            View.printHeader("삭제할 노선 이름을 입력하세요.");
            Model.deleteLine(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 노선이 삭제되었습니다.");
        } catch (Exception e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        }
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }

    public static Optional<ScreenType> listLine(ScreenType parentScreenType) {
        View.printHeader("노선 목록");
        Model.getAllLineNames().forEach(View::printInfo);
        View.printEmptyLine();
        return Optional.of(ScreenType.MAIN);
    }
}
