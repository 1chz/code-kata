package io.github.shirohoo.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RacingGameRunnerSettingsTests {
    @Test
    void createSettings() {
        String carNames = "shiro,siro";
        int tryCount = 3;

        assertThatCode(
                        () -> {
                            RacingGameSettings.of(carNames, tryCount, () -> true);
                        })
                .doesNotThrowAnyException();
    }

    @Test
    void createSettingsExceptionIfTryCountLessThanOne() {
        String carNames = "shiro,siro";
        int tryCount = 0;

        assertThatThrownBy(
                        () -> {
                            RacingGameSettings.of(carNames, tryCount, () -> true);
                        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void createSettingsExceptionIfCarNamesNullOrEmpty(String carNames) {
        int tryCount = 3;

        assertThatThrownBy(
                        () -> {
                            RacingGameSettings.of(carNames, tryCount, () -> true);
                        })
                .isOfAnyClassIn(IllegalArgumentException.class, NullPointerException.class);
    }

    @Test
    void carNames() {
        // ...given
        String carNames = "shiro,siro";
        int tryCount = 3;
        RacingGameSettings settings = RacingGameSettings.of(carNames, tryCount, () -> true);

        // ...when
        String names = settings.carNames();

        // ...then
        assertThat(names).isEqualTo("shiro,siro");
    }

    @Test
    void tryCount() {
        // ...given
        String carNames = "shiro,siro";
        int tryCount = 3;
        RacingGameSettings settings = RacingGameSettings.of(carNames, tryCount, () -> true);

        // ...when
        int count = settings.tryCount();

        // ...then
        assertThat(count).isEqualTo(3);
    }

    @Test
    void condition() {
        // ...given
        String carNames = "shiro,siro";
        int tryCount = 3;
        RacingGameSettings settings = RacingGameSettings.of(carNames, tryCount, () -> true);

        // ...when
        ForwardCondition condition = settings.condition();

        // ...then
        assertThat(condition).isInstanceOf(ForwardCondition.class);
    }
}
