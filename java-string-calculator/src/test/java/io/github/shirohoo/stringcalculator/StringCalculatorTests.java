package io.github.shirohoo.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTests {
    @ParameterizedTest
    @CsvSource(
            value = {"2+44-7*1/5:7.8", "2 + 44 - 7 * 1 / 5:7.8", "2 +44 -7 * 1 /5:7.8", "125161:125161"},
            delimiter = ':')
    void shouldReturnCorrectOperationResult(String args, double expected) {
        // given
        StringExpression expr = new StringExpression(args);
        StringCalculator sut = new StringCalculator();

        // when
        double actual = sut.calculate(expr);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
