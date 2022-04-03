package subway.controller;

import subway.Client;
import subway.domain.Line;
import subway.io.Input;
import subway.view.View;

public class LineController extends Controller {
    public LineController() {
        super("노선 관리 화면");
        commandRepository.createCommand('1', "노선 등록", this::addLine);
        commandRepository.createCommand('2', "노선 삭제", this::deleteLine);
        commandRepository.createCommand('3', "노선 조회", this::showLines);
        commandRepository.createCommand('B', "돌아가기", Client::goBack);
    }

    private void addLine() {
        Line newLine;
        try {
            View.printHeader("등록할 노선 이름을 입력하세요.");
            newLine = Line.createLine(Input.readLine());
            View.printEmptyLine();

            View.printHeader("등록할 노선 상행 종점역 이름을 입력하세요.");
            newLine.addStation(Input.readLine());
            View.printEmptyLine();

            View.printHeader("등록할 노선 하행 종점역 이름을 입력하세요.");
            newLine.addStation(Input.readLine());
            View.printEmptyLine();

            newLine.register();
            View.printInfo("지하철 노선이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }

    private void deleteLine() {
        try {
            View.printHeader("삭제할 노선 이름을 입력하세요.");
            Line.deleteLine(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 노선이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }

    private void showLines() {
        View.renderLineList();
        Client.goBack();
    }
}
