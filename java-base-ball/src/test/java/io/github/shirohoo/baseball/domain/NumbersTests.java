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
    void 중복되지않는_숫자_세개() {
        assertThatCode(() -> new Numbers("123")).doesNotThrowAnyException();
    }

    @Test
    void 중복되지않는_숫자_세개_예외() {
        assertThatThrownBy(() -> new Numbers("111")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_null_이면_예외() {
        assertThatThrownBy(() -> new Numbers(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되지않는_랜덤한_숫자_세개() {
        assertThatCode(Numbers::new).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    void 숫자를_입력받으면_비교결과를_반환한다(Numbers other, Score expected) {
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
