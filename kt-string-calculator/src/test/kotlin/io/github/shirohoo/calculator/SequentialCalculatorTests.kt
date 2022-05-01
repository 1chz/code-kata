package io.github.shirohoo.calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SequentialCalculatorTests {
    lateinit var sut: Calculator

    @BeforeEach
    fun setUp() {
        sut = SequentialCalculator()
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2+44-7*1/5:7.8",
            "2 + 44 - 7 * 1 / 5:7.8",
            "2 +44 -7 * 1 /5:7.8",
            "125161:125161"
        ],
        delimiter = ':'
    )
    fun `입력된 연산자의 순서대로 수식을 계산한다`(testCase: String, expected: Double) {
        val expr = Expression(testCase)

        val actual: Double = sut.calculate(expr)

        assertEquals(expected, actual)
    }
}
