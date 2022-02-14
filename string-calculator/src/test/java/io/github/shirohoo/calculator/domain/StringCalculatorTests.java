package io.github.shirohoo.calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class StringCalculatorTests {
    @Test
    void from() {
        Expression expression = Expression.from("2 + 4 - 7 * 1 / 0");

        assertThatCode(() -> {
            StringCalculator calculator = StringCalculator.from(expression);
        }).doesNotThrowAnyException();
    }

    @Test
    void fromException() {
        assertThatThrownBy(() -> {
            StringCalculator calculator = StringCalculator.from(null);
        }).isInstanceOf(NullPointerException.class);
    }
}