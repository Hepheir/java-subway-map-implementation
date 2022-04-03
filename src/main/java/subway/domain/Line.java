package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Line {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final static int MINIMUM_STATIONS_SIZE = 2;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public static List<Line> getLines() {
        return LineRepository.lines();
    }

    public static Line getLine(String name) throws IllegalArgumentException {
        Optional<Line> foundLine = getLines().stream().filter(line -> line.getName().equals(name)).findFirst();
        if (!foundLine.isPresent()) {
            throw new IllegalArgumentException("해당하는 노선이 없습니다.");
        }
        return foundLine.get();
    }

    public static void registerLine(Line line) throws IllegalArgumentException {
        if (line.stations().size() < MINIMUM_STATIONS_SIZE) {
            throw new IllegalArgumentException("2개 이상의 역을 등록해야 합니다.");
        }
        LineRepository.addLine(line);
    }

    public static Line createLine(String name) throws IllegalArgumentException {
        return new Line(name);
    }

    public static void deleteLine(String name) throws IllegalArgumentException {
        Line.getLine(name).delete();
    }

    public Line(String name) throws IllegalArgumentException {
        this.name = name;
        this.checkName();
        this.checkDuplicate();
    }

    public String getName() {
        return name;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(this.stations);
    }

    public void addStation(String name) throws IllegalArgumentException {
        Station.getStation(name).addLine(this);
    }

    public void register() throws IllegalArgumentException {
        Line.registerLine(this);
    }

    protected void addStation(Station station) {
        this.stations.add(station);
    }

    protected void addStation(Station station, int index) {
        this.stations.add(index, station);
    }

    protected void deleteStation(Station station) throws IllegalArgumentException {
        if (this.stations.size() <= Line.MINIMUM_STATIONS_SIZE) {
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.");
        }
        if (!this.stations.remove(station)) {
            throw new IllegalArgumentException("해당하는 역이 노선에 존재하지 않습니다.");
        }
    }

    private void checkName() throws IllegalArgumentException {
        if (this.name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    private void checkDuplicate() throws IllegalArgumentException {
        if (LineRepository.hasLine(this)) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
    }

    private void delete() {
        LineRepository.deleteLine(this);
    }
}
