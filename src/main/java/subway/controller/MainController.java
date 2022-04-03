package subway.controller;

import subway.Client;
import subway.view.View;

public class MainController extends Controller {
    public MainController() {
        super("메인 화면");
        commandRepository.createCommand('1', "역 관리", () -> { Client.open(new StationController()); });
        commandRepository.createCommand('2', "노선 관리", () -> { Client.open(new LineController()); });
        commandRepository.createCommand('3', "구간 관리", () -> { Client.open(new SectionController()); });
        commandRepository.createCommand('4', "지하철 노선도 출력", View::renderSubwayMap);
        commandRepository.createCommand('Q', "종료", Client::close);
    }
}
