package subway.view;

public class LineView extends View {
    public static void askLineNameToAdd() {
        View.printHeader("등록할 노선 이름을 입력하세요.");
    }

    public static void askUpperBoundStationNameToAdd() {
        View.printHeader("등록할 노선 상행 종점역 이름을 입력하세요.");
    }

    public static void askLowerBoundStationNameToAdd() {
        View.printHeader("등록할 노선 하행 종점역 이름을 입력하세요.");
    }

    public static void printLineAddedSuccessfully() {
        View.printInfo("지하철 노선이 등록되었습니다.");
    }

    public static void askLineNameToDelete() {
        View.printHeader("삭제할 노선 이름을 입력하세요.");
    }

    public static void printLineDeletedSuccessfully() {
        View.printInfo("지하철 노선이 삭제되었습니다.");
    }

    public static void printLineList() {
        View.printHeader("노선 목록");
    }
}
