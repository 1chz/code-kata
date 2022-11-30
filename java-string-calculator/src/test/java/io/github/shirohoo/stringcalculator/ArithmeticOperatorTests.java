package io.github.shirohoo.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ArithmeticOperatorTests {
    @MethodSource
    @ParameterizedTest
    void findByOperator(char operator, ArithmeticOperator expected) {
        ArithmeticOperator sut = ArithmeticOperator.findByOperator(operator);
        assertThat(sut).isEqualTo(expected);
    }

    static Stream<Arguments> findByOperator() {
        return Stream.of(
                Arguments.of('+', ArithmeticOperator.PLUS),
                Arguments.of('-', ArithmeticOperator.MINUS),
                Arguments.of('*', ArithmeticOperator.MULTIPLY),
                Arguments.of('/', ArithmeticOperator.DIVIDE));
    }

    @Test
    void shouldThrownExceptionThatNotDivisibleByZero() {
        ArithmeticOperator divide = ArithmeticOperator.DIVIDE;
        assertThatThrownBy(() -> divide.apply(1, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("not divisible by zero");
    }

    @ParameterizedTest
    @CsvSource(
            value = {"+:5:2:7", "-:5:2:3", "*:5:2:10", "/:5:2:2.5"},
            delimiter = ':')
    void shouldOperationResultMatchingTheOperatorMustBeReturned(
            char operator, double left, double right, double expected) {
        // given
        ArithmeticOperator sut = ArithmeticOperator.findByOperator(operator);

        // when
        double actual = sut.apply(left, right);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
