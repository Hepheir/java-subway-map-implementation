package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Station {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final String name;
    private final List<Line> lines = new ArrayList<>();

    public static List<Station> getStations() {
        return StationRepository.stations();
    }

    public static Station getStation(String name) throws IllegalArgumentException {
        Optional<Station> foundStation = getStations().stream()
            .filter(station -> station.getName().equals(name)).findFirst();
        if (!foundStation.isPresent()) {
            throw new IllegalArgumentException("해당하는 역이 없습니다.");
        }
        return foundStation.get();
    }

    public static Station createStation(String name) throws IllegalArgumentException {
        return new Station(name);
    }

    public static void deleteStation(String name) throws IllegalArgumentException {
        Station.getStation(name).delete();
    }

    private static void registerStation(Station station) {
        StationRepository.addStation(station);
    }

    public Station(String name) throws IllegalArgumentException {
        this.name = name;
        this.checkName();
        this.checkDuplicate();
        this.register();
    }

    public String getName() {
        return name;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        line.addStation(this);
        this.lines.add(line);
    }

    public void addLine(Line line, int index) {
        line.addStation(this, index);
        this.lines.add(line);
    }

    public void deleteLine(Line line) throws IllegalArgumentException {
        line.deleteStation(this);
        if (!this.lines.remove(line)) {
            throw new IllegalArgumentException("해당하는 역이 노선에 존재하지 않습니다.");
        }
    }

    private void checkName() throws IllegalArgumentException {
        if (this.name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }

    private void checkDuplicate() throws IllegalArgumentException {
        if (StationRepository.hasStation(this)) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
    }

    private void register() {
        Station.registerStation(this);
    }

    private void delete() throws IllegalArgumentException {
        if (lines.size() > 0) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
        StationRepository.deleteStation(this);
    }
}
