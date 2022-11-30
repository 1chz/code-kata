package io.github.shirohoo.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTests {
    @Test
    void shouldNotThrownAnyExceptionWhenInit() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> Lotto.from(numbers)).doesNotThrowAnyException();
    }

    @MethodSource
    @ParameterizedTest
    void shouldThrownExceptionWhenInit(Set<Integer> invalidNumbers) {
        assertThatThrownBy(() -> Lotto.from(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("lotto numbers must be not duplicated 6 numbers in range 1-45");
    }

    static Stream<Arguments> shouldThrownExceptionWhenInit() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 46)), // include 46
                Arguments.of(Set.of(0, 1, 2, 3, 4, 5, 45)), // include 0
                Arguments.of(Set.of(0, 1, 2, 3, 4, 46)), // include 0, 46
                Arguments.of(Set.of(1, 2, 3, 4, 5)) // size 5
                );
    }

    @MethodSource
    @ParameterizedTest
    void shouldDrawnNormally(Lotto lotto, MatchPrize expected) {
        // given
        Lotto winningLotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        // when
        MatchPrize matchPrize = lotto.drawn(winningLotto);

        // then
        assertThat(matchPrize).isEqualTo(expected);
    }

    static Stream<Arguments> shouldDrawnNormally() {
        return Stream.of(
                Arguments.of(Lotto.from(Set.of(1, 2, 3, 4, 5, 6)), MatchPrize.SIX),
                Arguments.of(Lotto.from(Set.of(1, 2, 3, 4, 5, 7)), MatchPrize.FIVE),
                Arguments.of(Lotto.from(Set.of(1, 2, 3, 4, 7, 8)), MatchPrize.FOUR),
                Arguments.of(Lotto.from(Set.of(1, 2, 3, 7, 8, 9)), MatchPrize.THREE),
                Arguments.of(Lotto.from(Set.of(1, 2, 7, 8, 9, 10)), MatchPrize.TWO),
                Arguments.of(Lotto.from(Set.of(1, 7, 8, 9, 10, 11)), MatchPrize.ONE),
                Arguments.of(Lotto.from(Set.of(7, 8, 9, 10, 11, 12)), MatchPrize.ZERO));
    }

    @Test
    void shouldReturnStringValue() {
        // given
        Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));

        // when
        String stringValue = lotto.stringValue();

        // then
        assertThat(stringValue).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
