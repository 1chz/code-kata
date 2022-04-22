package io.github.shirohoo.calculator.app.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
                Arguments.of('/', ArithmeticOperator.DIVIDE)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+:5:2:7",
            "-:5:2:3",
            "*:5:2:10",
            "/:5:2:2.5"
    }, delimiter = ':')
    void apply(char operator, double left, double right, double expected) {
        // given
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.findByOperator(operator);

        // when
        double sut = arithmeticOperator.apply(left, right);

        // then
        assertThat(sut).isEqualTo(expected);
    }
}
