package subway.view;

import java.util.Arrays;

import subway.io.Output;

public class View {
    private static final String PREFIX_INFO = "[INFO] ";
    private static final String PREFIX_ERROR = "[ERROR] ";
    private static final String PREFIX_HEADER = "## ";

    public static void printEmptyLine() {
        Output.printLine();
    }

    public static void printLine(String message) {
        Output.printLine(message);
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

    // Domain specifics

    public static final void printScreenName(String name) {
        printHeader(name);
    }

    public static final void printCommandFormat(Character key, String description) {
        printLine(String.format("%c. %s", key, description));
    }

    public static final void printCommandPromptMessage() {
        printHeader("원하는 기능을 선택하세요.");
    }

    public static final void printLineOfSubwayMap(String lineName, String... stationNames) {
        printInfo(lineName);
        printInfo("---");
        Arrays.asList(stationNames).forEach(View::printInfo);
    }
}
