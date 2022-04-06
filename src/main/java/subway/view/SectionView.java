package subway.view;

public class SectionView {
    public static void askLineName() {
        View.printHeader("노선을 입력하세요.");
    }

    public static void askStationName() {
        View.printHeader("역이름을 입력하세요.");
    }

    public static void askOrder() {
        View.printHeader("순서를 입력하세요.");
    }

    public static void printSectionAddedSuccessfully() {
        View.printInfo("구간이 등록되었습니다.");
    }

    public static void printErrorNotANumber() {
        View.printError("숫자가 아닙니다.");
    }

    public static void askLineNameToDelete() {
        View.printHeader("삭제할 구간의 노선을 입력하세요.");
    }

    public static void askStationNameToDelete() {
        View.printHeader("삭제할 구간의 역을 입력하세요.");
    }

    public static void printSectionDeletedSuccessfully() {
        View.printInfo("지하철 역이 삭제되었습니다.");
    }
}
