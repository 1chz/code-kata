package io.github.shirohoo.racing.app.domain;

import static java.util.Arrays.stream;

import java.util.Objects;

public record RacingGameSettings(String carNames, int tryCount, ForwardCondition condition) {
    public RacingGameSettings {
        assertThatNotNull(carNames, tryCount, condition);
        assertThatConditions(carNames, tryCount);
    }

    public static RacingGameSettings of(String carNames, int tryCount, ForwardCondition condition) {
        return new RacingGameSettings(carNames, tryCount, condition);
    }

    private void assertThatNotNull(Object... objects) {
        stream(objects).forEach(Objects::requireNonNull);
    }

    private void assertThatConditions(String carNames, int tryCount) {
        if (carNames.isBlank() || tryCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}
