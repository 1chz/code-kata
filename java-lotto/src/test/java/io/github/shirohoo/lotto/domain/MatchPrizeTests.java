package io.github.shirohoo.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchPrizeTests {
    @MethodSource
    @ParameterizedTest
    void shouldReturnMatchPrizeWhenFindByMatchCount(int matchCount, MatchPrize expected) {
        if (matchCount < 0 || matchCount > 6) {
            assertThatThrownBy(() -> MatchPrize.findByMatchCount(matchCount))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            MatchPrize result = MatchPrize.findByMatchCount(matchCount);
            assertThat(result).isEqualTo(expected);
        }
    }

    static Stream<Arguments> shouldReturnMatchPrizeWhenFindByMatchCount() {
        return Stream.of(
                Arguments.of(-1, null),
                Arguments.of(0, MatchPrize.ZERO),
                Arguments.of(1, MatchPrize.ONE),
                Arguments.of(2, MatchPrize.TWO),
                Arguments.of(3, MatchPrize.THREE),
                Arguments.of(4, MatchPrize.FOUR),
                Arguments.of(5, MatchPrize.FIVE),
                Arguments.of(6, MatchPrize.SIX),
                Arguments.of(7, null));
    }
}
