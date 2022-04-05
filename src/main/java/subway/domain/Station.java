package subway.domain;

import subway.exception.InvalidStationNameException;

public class Station {
    private final static int MINIMUM_NAME_LENGTH = 2;
    private final String name;

    private static void checkValid(String name) throws InvalidStationNameException {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new InvalidStationNameException();
        }
    }

    public Station(String name) throws InvalidStationNameException {
        Station.checkValid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
