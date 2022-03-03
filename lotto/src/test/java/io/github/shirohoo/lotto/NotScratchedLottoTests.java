package io.github.shirohoo.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.fixture.InvalidNumbers;
import io.github.shirohoo.fixture.InvalidNumbersResolver;
import io.github.shirohoo.fixture.ValidNumbers;
import io.github.shirohoo.fixture.ValidNumbersResolver;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(value = {ValidNumbersResolver.class, InvalidNumbersResolver.class})
class NotScratchedLottoTests {
    @Test
    void shouldNotThrownAnyExceptionWhenInit(@ValidNumbers Set<Integer> numbers) {
        assertThatCode(() -> {
            NotScratchedLotto notScratchedLotto = NotScratchedLotto.from(numbers);
        }).doesNotThrowAnyException();
    }

    @Test
    void shouldThrownIllegalArgumentExceptionWhenInit(@InvalidNumbers Set<Integer> numbers) {
        assertThatThrownBy(() -> {
            NotScratchedLotto notScratchedLotto = NotScratchedLotto.from(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldNotThrownAnyExceptionWhenScratch(@ValidNumbers Set<Integer> numbers) {
        // ...given
        WinnerLotto winnerLotto = WinnerLotto.from(Set.of(1, 2, 3, 4, 5, 6));
        NotScratchedLotto notScratchedLotto = NotScratchedLotto.from(numbers);

        // ...when
        ScratchedLotto scratchedLotto = notScratchedLotto.scratch(winnerLotto);

        // ...then
        assertThat(scratchedLotto.getMatchCount())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(6);
        assertThatThrownBy(() -> {
            scratchedLotto.scratch(winnerLotto);
        }).isInstanceOf(IllegalStateException.class);
    }
}
