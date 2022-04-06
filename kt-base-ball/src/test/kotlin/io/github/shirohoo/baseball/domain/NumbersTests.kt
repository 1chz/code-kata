package io.github.shirohoo.baseball.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class NumbersTests {
    @ParameterizedTest
    @ValueSource(strings = ["", "1", "11", "111"])
    fun `1부터 9까지의 중복되지 않는 수 세개가 입력되지 않으면 인스턴스가 생성되지 않는다`(invalidValues: String) {
        assertThrows<IllegalArgumentException> { Numbers(invalidValues) }
    }

    @ParameterizedTest
    @MethodSource("testCases")
    fun `컴퓨터의 숫자와 유저의 숫자를 비교한다`(userNumbers: Numbers, expected: MatchCounts) {
        val computerNumbers = Numbers("123")
        val matchCounts = computerNumbers.compare(userNumbers)
        assertEquals(expected, matchCounts)
    }

    companion object {
        @JvmStatic
        fun testCases(): Stream<Arguments> = Stream.of(
            Arguments.of(Numbers("123"), MatchCounts(0, 3)),
            Arguments.of(Numbers("124"), MatchCounts(0, 2)),
            Arguments.of(Numbers("145"), MatchCounts(0, 1)),
            Arguments.of(Numbers("135"), MatchCounts(1, 1)),
            Arguments.of(Numbers("132"), MatchCounts(2, 1)),
            Arguments.of(Numbers("345"), MatchCounts(1, 0)),
            Arguments.of(Numbers("234"), MatchCounts(2, 0)),
            Arguments.of(Numbers("789"), MatchCounts(0, 0))
        )
    }
}
