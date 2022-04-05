package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import subway.exception.LineAlreadyExsitsException;
import subway.exception.LineNotFoundException;

public class LineRepository {
    private static final List<Line> lines = new LinkedList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void add(Line line) throws LineAlreadyExsitsException {
        checkAddable(line);
        lines.add(line);
    }

    public static void delete(Line line) throws LineNotFoundException {
        checkDeletable(line);
        lines.remove(line);
    }

    private static boolean contains(Line line) {
        return lines.stream()
            .map(Line::getName)
            .filter(name -> line.getName().equals(name))
            .findAny()
            .isPresent();
    }

    private static void checkAddable(Line line) throws LineAlreadyExsitsException {
        if (contains(line)) {
            throw new LineAlreadyExsitsException();
        }
    }

    private static void checkDeletable(Line line) throws LineNotFoundException {
        if (!contains(line)) {
            throw new LineNotFoundException();
        }
    }
}
