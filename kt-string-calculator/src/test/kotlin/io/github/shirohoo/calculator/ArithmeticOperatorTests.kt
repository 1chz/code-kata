package io.github.shirohoo.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ArithmeticOperatorTests {
    @MethodSource
    @ParameterizedTest
    fun findByOperator(operator: Char, expected: ArithmeticOperator?) {
        assertEquals(expected, ArithmeticOperator.findByOperator(operator))
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "+:5:2:7",
            "-:5:2:3",
            "*:5:2:10",
            "/:5:2:2.5"
        ],
        delimiter = ':'
    )
    fun apply(operator: Char, left: Double, right: Double, expected: Double) {
        val sut: ArithmeticOperator = ArithmeticOperator.findByOperator(operator)

        val actual: Double = sut.apply(left, right)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findByOperator(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of('+', ArithmeticOperator.PLUS),
                Arguments.of('-', ArithmeticOperator.MINUS),
                Arguments.of('*', ArithmeticOperator.MULTIPLY),
                Arguments.of('/', ArithmeticOperator.DIVIDE)
            )
        }
    }
}
