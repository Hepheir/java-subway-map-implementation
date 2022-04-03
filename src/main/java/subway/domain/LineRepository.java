package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    protected static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    protected static void addLine(Line line) {
        lines.add(line);
    }

    protected static void deleteLine(Line line) {
        lines.remove(line);
    }

    protected static boolean hasLine(Line line) {
        return lines.stream().map(Line::getName).collect(Collectors.toList()).contains(line.getName());
    }
}
