package subway.model;

import java.util.Optional;

import subway.domain.Line;
import subway.domain.Station;
import subway.exception.NotEnoughStationsException;
import subway.exception.SectionNotAddableException;
import subway.exception.SectionNotDeletableException;
import subway.exception.StationNotFoundException;

public class SectionEdit {
    private Optional<Line> line = Optional.empty();
    private Optional<Station> station = Optional.empty();
    private Optional<Integer> order = Optional.empty();

    public void setLine(String name) throws StationNotFoundException {
        this.line = Optional.of(Model.getLine(name));
    }

    public void setStation(String name) throws StationNotFoundException {
        this.station = Optional.of(Model.getStation(name));
    }

    public void setOrder(int index) {
        this.order = Optional.of(index);
    }

    public void add() throws SectionNotAddableException, IndexOutOfBoundsException {
        if (!isReadyToAdd()) {
            throw new SectionNotAddableException();
        }
        this.line.get().add(this.station.get(), this.order.get());
    }

    public void delete() throws
        SectionNotDeletableException,
        NotEnoughStationsException,
        StationNotFoundException
    {
        if (!isReadyToDelete()) {
            throw new SectionNotDeletableException();
        }
        this.line.get().delete(this.station.get());
    }

    private boolean isReadyToAdd() {
        return line.isPresent() && station.isPresent() && order.isPresent();
    }

    private boolean isReadyToDelete() {
        return line.isPresent() && station.isPresent();
    }
}
