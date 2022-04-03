package subway.controller;

import subway.Client;
import subway.domain.Line;
import subway.domain.Station;
import subway.io.Input;
import subway.view.View;

public class SectionController extends Controller {
    public SectionController() {
        super("구간 관리 화면");
        commandRepository.createCommand('1', "구간 등록", this::addSection);
        commandRepository.createCommand('2', "구간 삭제", this::deleteSection);
        commandRepository.createCommand('B', "돌아가기", Client::goBack);
    }

    private void addSection() {
        Line targetLine;
        Station targetStation;
        int targetOrder;
        try {
            View.printHeader("노선을 입력하세요.");
            targetLine = Line.getLine(Input.readLine());
            View.printEmptyLine();

            View.printHeader("역이름을 입력하세요.");
            targetStation = Station.getStation(Input.readLine());
            View.printEmptyLine();

            View.printHeader("순서를 입력하세요.");
            targetOrder = Input.readInt();
            View.printEmptyLine();

            targetStation.addLine(targetLine, targetOrder);
            View.printInfo("구간이 등록되었습니다.");
        } catch (NumberFormatException e) {
            View.printEmptyLine();
            View.printError("숫자가 아닙니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }

    private void deleteSection() {
        Line targetLine;
        Station targetStation;
        try {
            View.printHeader("삭제할 구간의 노선을 입력하세요.");
            targetLine = Line.getLine(Input.readLine());
            View.printEmptyLine();

            View.printHeader("삭제할 구간의 역을 입력하세요.");
            targetStation = Station.getStation(Input.readLine());
            View.printEmptyLine();

            targetStation.deleteLine(targetLine);
            View.printInfo("지하철 역이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }
}
