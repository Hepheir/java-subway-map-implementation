package subway.view;

import java.util.List;

import subway.command.Command;
import subway.controller.Controller;
import subway.domain.Line;
import subway.domain.Station;
import subway.io.Output;

public class View {
    private static final String PREFIX_INFO = "[INFO] ";
    private static final String PREFIX_ERROR = "[ERROR] ";
    private static final String PREFIX_HEADER = "## ";

    public static void printEmptyLine() {
        Output.printLine();
    }

    public static void printHeader(String message) {
        Output.printLine(String.format("%s%s", PREFIX_HEADER, message));
    }

    public static void printInfo(String message) {
        Output.printLine(String.format("%s%s", PREFIX_INFO, message));
    }

    public static void printError(String message) {
        Output.printLine(String.format("%s%s", PREFIX_ERROR, message));
    }

    public static final void renderController(Controller controller) {
        printHeader(controller.getLabel());
        renderCommands(controller.commands());
        printEmptyLine();
    }

    public static final void renderCommandGuide() {
        printHeader("원하는 기능을 선택하세요.");
    }

    public static final void renderSubwayMap() {
        printHeader("지하철 노선도");
        Line.getLines().forEach(line -> {
            printInfo(line.getName());
            printInfo("---");
            line.stations().forEach(station -> printInfo(station.getName()));
            printEmptyLine();
        });
    }

    public static final void renderStationList() {
        printHeader("역 목록");
        Station.getStations().stream().map(Station::getName).forEach(View::printInfo);
        printEmptyLine();
    }

    public static final void renderLineList() {
        printHeader("노선 목록");
        Line.getLines().stream().map(Line::getName).forEach(View::printInfo);
        printEmptyLine();
    }

    private static final void renderCommands(List<Command> commands) {
        commands.forEach(View::renderCommand);
    }

    private static final void renderCommand(Command command) {
        Output.printLine(String.format("%c. %s", command.getKey(), command.getLabel()));
    }
}
