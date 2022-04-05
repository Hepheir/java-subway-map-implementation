package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final static int MINIMUM_STATIONS_SIZE = 2;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name, Station... stations) throws IllegalArgumentException {
        this.checkValid(name);
        this.checkEnough(stations);
        this.name = name;
        Arrays.asList(stations).forEach(this::add);
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(this.stations);
    }

    public String getName() {
        return name;
    }

    public void add(Station station) {
        this.stations.add(station);
    }

    public void add(Station station, int index) {
        this.stations.add(index, station);
    }

    public void delete(Station station) throws IllegalArgumentException {
        this.checkDeletable(station);
        this.stations.remove(station);
    }

    private void checkValid(String name) throws IllegalArgumentException {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    private void checkEnough(Station[] stations) throws IllegalArgumentException {
        if (stations.length < MINIMUM_STATIONS_SIZE) {
            throw new IllegalArgumentException("노선을 생성하기 위해 상행종점역과 하행종점역을 입력해야 합니다.");
        }
    }

    private void checkDeletable(Station station) throws IllegalArgumentException {
        if (this.stations.size() <= Line.MINIMUM_STATIONS_SIZE) {
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
        if (!this.stations.contains(station)) {
            throw new IllegalArgumentException("해당하는 역이 노선에 존재하지 않습니다.");
        }
    }
}
