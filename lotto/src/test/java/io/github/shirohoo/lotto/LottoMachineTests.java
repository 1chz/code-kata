package io.github.shirohoo.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import java.util.Set;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoMachineTests {
    @Test
    void init() {
        assertThatCode(LottoMachine::new)
            .doesNotThrowAnyException();
    }

    @RepeatedTest(100)
    void ticketing() {
        // ...given
        LottoMachine machine = new LottoMachine();

        // ...when
        Set<Integer> numbers = machine.ticketing();

        // ...then
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.stream().mapToInt(i -> i).sum())
            .isGreaterThanOrEqualTo(21)
            .isLessThanOrEqualTo(255);
    }
}
