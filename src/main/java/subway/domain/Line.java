package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final static int MINIMUM_STATIONS_SIZE = 2;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) throws IllegalArgumentException {
        this.name = name;
        this.checkValid(name);
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(this.stations);
    }

    public String getName() {
        return name;
    }

    protected void add(Station station) {
        this.stations.add(station);
    }

    protected void add(Station station, int index) {
        this.stations.add(index, station);
    }

    protected void delete(Station station) throws IllegalArgumentException {
        if (this.stations.size() <= Line.MINIMUM_STATIONS_SIZE) {
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
        if (!this.stations.remove(station)) {
            throw new IllegalArgumentException("해당하는 역이 노선에 존재하지 않습니다.");
        }
    }

    private void checkValid(String name) throws IllegalArgumentException {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }
    }
}
