package subway.view;

public class MainView {
    public static final void printLineName(String lineName) {
        View.printInfo(lineName);
    }

    public static final void printLineAndStationsSeperator() {
        View.printInfo("---");
    }

    public static final void printStationName(String stationName) {
        View.printInfo(stationName);
    }
}
