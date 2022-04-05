package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations = new LinkedList<>();

    protected static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    protected static void add(Station station) {
        stations.add(station);
    }

    protected static void delete(Station station) {
        stations.remove(station);
    }

    protected static boolean has(Station station) {
        return stations.stream().map(Station::getName).collect(Collectors.toList()).contains(station.getName());
    }
}
