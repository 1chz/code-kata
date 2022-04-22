package io.github.shirohoo.calculator.app.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTests {
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2+44-7*1/5:7.8",
            "2 + 44 - 7 * 1 / 5:7.8",
            "2 +44 -7 * 1 /5:7.8",
            "125161:125161"
    }, delimiter = ':')
    void calculate(String args, double expected) {
        // given
        StringExpression expr = new StringExpression(args);

        // when
        double result = calculator.calculate(expr);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
