package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class ApplicationInitializer {
    public static void init() {
        Station stationKD = new Station("교대역");
        Station stationGN = new Station("강남역");
        Station stationYS = new Station("역삼역");
        Station stationNT = new Station("남부터미널역");
        Station stationYJ = new Station("양재역");
        Station stationYF = new Station("양재시민의숲역");
        Station stationMB = new Station("매봉역");

        Line line2 = new Line("2호선", stationKD, stationGN, stationYS);
        Line line3 = new Line("3호선", stationKD, stationNT, stationYJ, stationMB);
        Line lineDX = new Line("신분당선", stationGN, stationYJ, stationYF);

        StationRepository.add(stationKD);
        StationRepository.add(stationGN);
        StationRepository.add(stationYS);
        StationRepository.add(stationNT);
        StationRepository.add(stationYJ);
        StationRepository.add(stationYF);
        StationRepository.add(stationMB);

        LineRepository.add(line2);
        LineRepository.add(line3);
        LineRepository.add(lineDX);
    }
}
