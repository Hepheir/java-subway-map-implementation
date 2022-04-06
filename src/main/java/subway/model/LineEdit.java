package subway.model;

import java.util.Optional;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exception.InvalidStationNameException;
import subway.exception.LineAlreadyExsitsException;
import subway.exception.LineNotAddableException;
import subway.exception.NotEnoughStationsException;
import subway.exception.StationNotFoundException;

public class LineEdit {
    private Optional<String> name = Optional.empty();
    private Optional<Station> upperBoundStation = Optional.empty();
    private Optional<Station> lowerBoundStation = Optional.empty();

    private static void checkDuplicate(String name) throws LineAlreadyExsitsException {
        if (Model.findLine(name).isPresent()) {
            throw new LineAlreadyExsitsException();
        }
    }

    public void setLineName(String name) throws InvalidStationNameException, LineAlreadyExsitsException {
        Line.checkValid(name);
        LineEdit.checkDuplicate(name);
        this.name = Optional.of(name);
    }

    public void setUpperBoundStationName(String name) throws StationNotFoundException {
        this.upperBoundStation = Optional.of(Model.getStation(name));
    }

    public void setLowerBoundStationName(String name) throws StationNotFoundException {
        this.lowerBoundStation = Optional.of(Model.getStation(name));
    }

    public void add() throws
        LineNotAddableException,
        InvalidStationNameException,
        NotEnoughStationsException,
        LineAlreadyExsitsException
    {
        if (!isAddable()) {
            throw new LineNotAddableException();
        }
        LineRepository.add(new Line(
            name.get(),
            upperBoundStation.get(),
            lowerBoundStation.get()
        ));
    }

    private boolean isAddable() {
        return name.isPresent()
            && upperBoundStation.isPresent()
            && lowerBoundStation.isPresent();
    }
}
