package io.github.shirohoo.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.github.shirohoo.domain.Numbers;
import io.github.shirohoo.domain.Score;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumbersTests {
    @Test
    void shouldPassIfEnteredNonDuplicated3Numbers() {
        assertThatCode(() -> new Numbers("123")).doesNotThrowAnyException();
    }

    @Test
    void shouldPassIfEnteredDuplicated3Numbers() {
        assertThatThrownBy(() -> new Numbers("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldPassIfEnteredNull() {
        assertThatThrownBy(() -> new Numbers(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    void shouldReturnScoreComparingTwoNumbers(Numbers other, Score expected) {
        // given
        Numbers self = new Numbers("123");

        // when
        Score actual = self.compareTo(other);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideCases() {
        return Stream.of(
                Arguments.of(new Numbers("123"), new Score(0, 3)),
                Arguments.of(new Numbers("124"), new Score(0, 2)),
                Arguments.of(new Numbers("145"), new Score(0, 1)),
                Arguments.of(new Numbers("321"), new Score(2, 1)),
                Arguments.of(new Numbers("231"), new Score(3, 0)),
                Arguments.of(new Numbers("235"), new Score(2, 0)),
                Arguments.of(new Numbers("435"), new Score(1, 0)),
                Arguments.of(new Numbers("456"), new Score(0, 0)));
    }
}
