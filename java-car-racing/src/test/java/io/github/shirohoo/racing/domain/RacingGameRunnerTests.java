package io.github.shirohoo.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameRunnerTests {
    @Test
    void createRacingGame() {
        RacingGameSettings settings = RacingGameSettings.of("siro", 3, () -> true);

        assertThatCode(() -> {
                    RacingGameRunner.from(settings);
                })
                .doesNotThrowAnyException();
    }

    @Test
    void createRacingGameExceptionIfSettingsNull() {
        assertThatThrownBy(() -> {
                    RacingGameRunner.from(null);
                })
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void eachRound() {
        // ...given
        RacingGameSettings settings = RacingGameSettings.of("siro", 3, () -> true);
        RacingGameRunner racingGameRunner = RacingGameRunner.from(settings);

        // ...when
        List<List<Car>> eachRound = racingGameRunner.eachRound();

        // ...then
        assertThat(eachRound).flatMap(ArrayList::new).map(Car::currentPosition).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    void winners() {
        // ...given
        RacingGameSettings settings = RacingGameSettings.of("siro", 3, () -> true);
        RacingGameRunner racingGameRunner = RacingGameRunner.from(settings);

        // ...when
        List<Car> winners = racingGameRunner.winners();

        // ...then
        assertThat(winners).extracting("name").containsExactly("siro");
    }
}
