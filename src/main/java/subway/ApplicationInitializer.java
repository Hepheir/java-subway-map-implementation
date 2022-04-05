package subway;

import subway.model.Model;

public class ApplicationInitializer {
    public static void init() {
        initStations();
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
}
