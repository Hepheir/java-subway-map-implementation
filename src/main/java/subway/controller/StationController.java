package subway.controller;

import subway.Client;
import subway.domain.Station;
import subway.io.Input;
import subway.view.View;

public class StationController extends Controller {
    public StationController() {
        super("역 관리 화면");
        commandRepository.createCommand('1', "역 등록", this::addStation);
        commandRepository.createCommand('2', "역 삭제", this::deleteStation);
        commandRepository.createCommand('3', "역 조회", this::showStations);
        commandRepository.createCommand('B', "돌아가기", Client::goBack);
    }

    private void addStation() {
        try {
            View.printHeader("등록할 역 이름을 입력하세요.");
            Station.createStation(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 역이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }

    private void deleteStation() {
        try {
            View.printHeader("삭제할 역 이름을 입력하세요.");
            Station.deleteStation(Input.readLine());
            View.printEmptyLine();
            View.printInfo("지하철 역이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            View.printEmptyLine();
            View.printError(e.getMessage());
        } finally {
            View.printEmptyLine();
            Client.goBack();
        }
    }

    private void showStations() {
        View.renderStationList();
        Client.goBack();
    }
}
