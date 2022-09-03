package io.github.shirohoo.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import static java.lang.System.lineSeparator;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

class LottosTests {
    @Test
    void shouldNotThrownAnyExceptionWhenInit() {
        assertThatCode(
                        () -> {
                            Lottos lottos = Lottos.from(Collections.emptyList());
                        })
                .doesNotThrowAnyException();
    }

    @Test
    void shouldReturnStringValue() {
        // ...given
        Lotto winningLotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        Lottos lottos =
                Lottos.from(
                        List.of(
                                Lotto.from(Set.of(1, 2, 3, 4, 5, 6)),
                                Lotto.from(Set.of(40, 41, 42, 43, 44, 45))));

        // ...when
        String stringValue = lottos.stringValue();

        // ...then
        assertThat(stringValue)
                .isEqualTo(
                        "[1, 2, 3, 4, 5, 6]%s[40, 41, 42, 43, 44, 45]".formatted(lineSeparator()));
    }

    @Test
    void shouldDrawnNormally() {
        // ...given
        Lotto winningLotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
        Lottos lottos =
                Lottos.from(
                        List.of(
                                Lotto.from(Set.of(1, 2, 3, 4, 5, 6)),
                                Lotto.from(Set.of(40, 41, 42, 43, 44, 45))));

        // ...when
        Statistics statistics = lottos.drawn(winningLotto);

        // ...then
        assertThat(statistics.countOfWinningLotto(MatchPrize.SIX)).isEqualTo(1);
        assertThat(statistics.countOfWinningLotto(MatchPrize.ZERO)).isEqualTo(1);
    }
}
