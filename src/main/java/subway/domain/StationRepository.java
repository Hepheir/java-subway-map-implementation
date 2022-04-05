package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import subway.exception.OccupiedStationException;
import subway.exception.StationAlreadyExsitsException;
import subway.exception.StationNotFoundException;

public class StationRepository {
    private static final List<Station> stations = new LinkedList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void add(Station station) throws StationAlreadyExsitsException {
        checkAddable(station);
        stations.add(station);
    }

    public static void delete(Station station) throws StationNotFoundException, OccupiedStationException {
        checkDeletable(station);
        stations.remove(station);
    }

    private static boolean contains(Station station) {
        return stations.stream()
            .map(Station::getName)
            .collect(Collectors.toList())
            .contains(station.getName());
    }

    private static void checkAddable(Station station) throws StationAlreadyExsitsException {
        if (contains(station)) {
            throw new StationAlreadyExsitsException();
        }
    }

    private static void checkDeletable(Station station) throws StationNotFoundException, OccupiedStationException {
        if (!contains(station)) {
            throw new StationNotFoundException();
        }
        if (isOccupied(station)) {
            throw new OccupiedStationException();
        }
    }

    private static boolean isOccupied(Station station) {
        return LineRepository.lines().stream()
            .filter(line -> line.stations().contains(station))
            .findAny()
            .isPresent();
    }
}
