package subway.view;

public class StationView {
    public static void askStationNameToAdd() {
        View.printHeader("등록할 역 이름을 입력하세요.");
    }

    public static void printStationAddedSuccessfully() {
        View.printInfo("지하철 역이 등록되었습니다.");
    }

    public static void askStationNameToDelete() {
        View.printHeader("삭제할 역 이름을 입력하세요.");
    }

    public static void printStationDeletedSuccessfully() {
        View.printInfo("지하철 역이 삭제되었습니다.");
    }

    public static void printStationList() {
        View.printHeader("역 목록");
    }
}
