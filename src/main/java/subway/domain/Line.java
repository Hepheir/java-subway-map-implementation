package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import subway.exception.InvalidStationNameException;
import subway.exception.NotEnoughStationsException;
import subway.exception.StationNotFoundException;

public class Line {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final static int MINIMUM_STATIONS_SIZE = 2;
    private final String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name, Station... stations) throws InvalidStationNameException, NotEnoughStationsException {
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

    public void delete(Station station) throws NotEnoughStationsException, StationNotFoundException {
        this.checkDeletable(station);
        this.stations.remove(station);
    }

    private void checkValid(String name) throws InvalidStationNameException {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new InvalidStationNameException();
        }
    }

    private void checkEnough(Station[] stations) throws NotEnoughStationsException {
        if (stations.length < MINIMUM_STATIONS_SIZE) {
            throw new NotEnoughStationsException();
        }
    }

    private void checkDeletable(Station station) throws NotEnoughStationsException, StationNotFoundException {
        if (this.stations.size() <= Line.MINIMUM_STATIONS_SIZE) {
            throw new NotEnoughStationsException();
        }
        if (!this.stations.contains(station)) {
            throw new StationNotFoundException();
        }
    }
}
