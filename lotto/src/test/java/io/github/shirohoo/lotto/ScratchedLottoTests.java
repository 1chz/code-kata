package io.github.shirohoo.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.fixture.ValidNumbers;
import io.github.shirohoo.fixture.ValidNumbersResolver;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ValidNumbersResolver.class)
class ScratchedLottoTests {
    @Test
    void shouldThrownIllegalStateExceptionWhenScratch(@ValidNumbers Set<Integer> numbers) {
        ScratchedLotto scratchedLotto = ScratchedLotto.of(6, numbers);

        assertThatThrownBy(() -> {
            scratchedLotto.scratch(null);
        }).isInstanceOf(IllegalStateException.class)
            .hasMessage("It's already a scratched lotto");
    }
}
