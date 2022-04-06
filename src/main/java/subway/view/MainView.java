package subway.view;

public class MainView extends View {
    public static final void printLineName(String lineName) {
        View.printInfo(lineName);
    }

    public static final void printLineAndStationsSeperator() {
        View.printInfo("---");
    }

    public static final void printStationName(String stationName) {
        View.printInfo(stationName);
    }

    public static final void printSubwayMapTitle() {
        View.printHeader("지하철 노선도");
    }
}
