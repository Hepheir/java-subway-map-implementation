package subway.command;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import subway.enums.ScreenType;

public class Command {
    private List<ScreenType> allowedScreenTypes;
    private Character key;
    private String description;
    private Function<ScreenType, Optional<ScreenType>> action;

    public Command(
        Character key,
        String description,
        Function<ScreenType, Optional<ScreenType>> action,
        ScreenType... allowedScreenTypes
    ) {
        this.allowedScreenTypes = Arrays.asList(allowedScreenTypes);
        this.key = key;
        this.description = description;
        this.action = action;
    }

    public List<ScreenType> getAllowedScreenTypes() {
        return this.allowedScreenTypes;
    }

    public Character getKey() {
        return this.key;
    }

    public String getDescription() {
        return this.description;
    }

    public Optional<ScreenType> executeFrom(ScreenType screenType) {
        return this.action.apply(screenType);
    }
}
