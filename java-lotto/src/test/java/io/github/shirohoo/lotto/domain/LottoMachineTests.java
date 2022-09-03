package io.github.shirohoo.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTests {
    @Test
    void shouldNotThrownAnyExceptionWhenInit() {
        assertThatCode(LottoMachine::new).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void shouldReturnLottoFromStringNumbers(String winningNumbers) {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        Lotto lotto = lottoMachine.ticketing(winningNumbers);

        // then
        assertThat(lotto).isNotNull().isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrownExceptionWhenNullOrEmpty(String winningNumbers) {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when | then
        assertThatThrownBy(() -> lottoMachine.ticketing(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("winningNumbers cannot be null or empty");
    }

    @RepeatedTest(100)
    void shouldDrawnCorrectNumbersWhenTicketing() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        Lotto lotto = lottoMachine.ticketing();

        // then
        assertThat(lotto).isNotNull().isInstanceOf(Lotto.class);
    }

    @Test
    void shouldReturnLottosFromPurchaseOfNumber() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        Lottos lottos = lottoMachine.ticketing(10);

        // then
        assertThat(lottos).isNotNull().isInstanceOf(Lottos.class);
    }
}
