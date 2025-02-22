package subway.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.InvalidLineNameException;
import subway.exception.InvalidStationNameException;
import subway.exception.LineAlreadyExsitsException;
import subway.exception.LineNotFoundException;
import subway.exception.NotEnoughStationsException;
import subway.exception.OccupiedStationException;
import subway.exception.StationAlreadyExsitsException;
import subway.exception.StationNotFoundException;

public class Model {

    // Station Mangements

    public static void createStation(String name) throws InvalidStationNameException, StationAlreadyExsitsException {
        StationRepository.add(new Station(name));
    }

    public static void deleteStation(String name) throws StationNotFoundException, OccupiedStationException {
        StationRepository.delete(getStation(name));
    }

    public static List<String> getAllStationNames() {
        return StationRepository.stations().stream()
            .map(Station::getName)
            .collect(Collectors.toList());
    }

    // Line Mangements

    public static void createLine(String name, String... namesOfStations) throws
        StationNotFoundException,
        InvalidLineNameException,
        NotEnoughStationsException,
        LineAlreadyExsitsException
    {
        Station[] stations = getStations(namesOfStations).stream().toArray(Station[]::new);
        Line newLine = new Line(name, stations);
        LineRepository.add(newLine);
    }

    public static void deleteLine(String name) throws LineNotFoundException {
        LineRepository.delete(getLine(name));
    }

    public static List<String> getAllLineNames() {
        return LineRepository.lines().stream()
            .map(Line::getName)
            .collect(Collectors.toList());
    }

    public static List<String> getAllStationNamesOfLine(String lineName) {
        return getLine(lineName).stations().stream()
            .map(Station::getName)
            .collect(Collectors.toList());
    }

    protected static Station getStation(String name) throws StationNotFoundException {
        Optional<Station> foundStation = findStation(name);
        if (!foundStation.isPresent()) {
            throw new StationNotFoundException();
        }
        return foundStation.get();
    }

    protected static Optional<Line> findLine(String name) {
        return LineRepository.lines().stream()
            .filter(line -> line.getName().equals(name))
            .findAny();
    }

    protected static Line getLine(String name) throws LineNotFoundException {
        Optional<Line> foundLine = findLine(name);
        if (!foundLine.isPresent()) {
            throw new LineNotFoundException();
        }
        return foundLine.get();
    }

    private static Optional<Station> findStation(String name) {
        return StationRepository.stations().stream()
            .filter(station -> station.getName().equals(name))
            .findAny();
    }

    private static List<Station> getStations(String... namesOfStations) throws StationNotFoundException {
        return Arrays.asList(namesOfStations).stream()
            .map(Model::getStation)
            .collect(Collectors.toList());
    }
}
