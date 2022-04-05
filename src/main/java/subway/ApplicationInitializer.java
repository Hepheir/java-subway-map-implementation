package subway;

import subway.command.Command;
import subway.command.CommandRepository;
import subway.controller.Controller;
import subway.controller.LineController;
import subway.controller.MainController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.enums.ScreenType;
import subway.model.Model;

public class ApplicationInitializer {
    public static void init() {
        initStations();
        initCommands();
    }

    private static void initStations() {
        Model.createStation("교대역");
        Model.createStation("강남역");
        Model.createStation("역삼역");
        Model.createStation("남부터미널역");
        Model.createStation("양재역");
        Model.createStation("양재시민의숲역");
        Model.createStation("매봉역");

        Model.createLine("2호선", "교대역", "강남역", "역삼역");
        Model.createLine("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        Model.createLine("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    public static void initCommands() {
        Command[] mainCommands = {
            new Command('1', "역 관리", MainController::openStationManager, ScreenType.MAIN),
            new Command('2', "노선 관리", MainController::openLineManager, ScreenType.MAIN),
            new Command('3', "구간 관리", MainController::openSectionManager, ScreenType.MAIN),
            new Command('4', "지하철 노선도 출력", MainController::openSubwayMap, ScreenType.MAIN),
        };

        Command[] stationCommands = {
            new Command('1', "역 등록", StationController::addStation, ScreenType.STATION_MANAGEMENT),
            new Command('2', "역 삭제", StationController::deleteStation, ScreenType.STATION_MANAGEMENT),
            new Command('3', "역 조회", StationController::listStation, ScreenType.STATION_MANAGEMENT),
        };

        Command[] lineCommands = {
            new Command('1', "노선 등록", LineController::addLine, ScreenType.LINE_MANAGEMENT),
            new Command('2', "노선 삭제", LineController::deleteLine, ScreenType.LINE_MANAGEMENT),
            new Command('3', "노선 조회", LineController::listLine, ScreenType.LINE_MANAGEMENT),
        };

        Command[] sectionCommands = {
            new Command('1', "구간 등록", SectionController::addSection, ScreenType.SECTION_MANAGEMENT),
            new Command('2', "구간 삭제", SectionController::deleteSection, ScreenType.SECTION_MANAGEMENT),
        };

        Command[] commonCommands = {
            new Command('B', "돌아가기", Controller::back, ScreenType.valuesExcept(ScreenType.MAIN)),
            new Command('Q', "종료", Controller::quit, ScreenType.MAIN),
        };

        CommandRepository.add(mainCommands);
        CommandRepository.add(stationCommands);
        CommandRepository.add(lineCommands);
        CommandRepository.add(sectionCommands);
        CommandRepository.add(commonCommands);
    }
}
