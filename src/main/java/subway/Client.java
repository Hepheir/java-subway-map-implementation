package subway;

import java.util.Stack;

import subway.controller.Controller;
import subway.controller.MainController;
import subway.domain.Line;
import subway.domain.Station;

public class Client {
    private static Stack<Controller> contollerStack = new Stack<>();

    public static void init() {
        Line line2 = Line.createLine("2호선");
        Line line3 = Line.createLine("3호선");
        Line lineDX = Line.createLine("신분당선");

        Station stationKD = Station.createStation("교대역");
        Station stationGN = Station.createStation("강남역");
        Station stationYS = Station.createStation("역삼역");
        Station stationNT = Station.createStation("남부터미널역");
        Station stationYJ = Station.createStation("양재역");
        Station stationYF = Station.createStation("양재시민의숲역");
        Station stationMB = Station.createStation("매봉역");

        stationKD.addLine(line2);
        stationGN.addLine(line2);
        stationYS.addLine(line2);

        stationKD.addLine(line3);
        stationNT.addLine(line3);
        stationYJ.addLine(line3);
        stationMB.addLine(line3);

        stationGN.addLine(lineDX);
        stationYJ.addLine(lineDX);
        stationYF.addLine(lineDX);

        Line.registerLine(line2);
        Line.registerLine(line3);
        Line.registerLine(lineDX);

        Client.open(new MainController());
    }

    public static void run() {
        while (!contollerStack.isEmpty()) {
            contollerStack.peek().render();
        };
    }

    public static void open(Controller controller) {
        contollerStack.add(controller);
    }

    public static void goBack() {
        contollerStack.pop();
    }

    public static void close() {
        contollerStack.clear();
    }
}
