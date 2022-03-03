package io.github.shirohoo.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.fixture.ValidNumbers;
import io.github.shirohoo.fixture.ValidNumbersResolver;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ValidNumbersResolver.class)
class WinnerLottoTests {
    @Test
    void shouldThrownIllegalStateExceptionWhenScratch(@ValidNumbers Set<Integer> numbers) {
        WinnerLotto winnerLotto = WinnerLotto.from(numbers);

        assertThatThrownBy(() -> {
            winnerLotto.scratch(null);
        }).isInstanceOf(IllegalStateException.class)
            .hasMessage("It's already a scratched lotto");
    }
}
