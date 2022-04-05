package io.github.shirohoo.baseball.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class NumbersGeneratorTests {
    @RepeatedTest(10)
    fun `1부터 9까지의 중복되지 않는 랜덤한 수 세개가 생성된다`() {
        assertDoesNotThrow(NumbersGenerator::generate)
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
            of(Numbers("123"), MatchCounts(0, 3)),
            of(Numbers("124"), MatchCounts(0, 2)),
            of(Numbers("145"), MatchCounts(0, 1)),
            of(Numbers("135"), MatchCounts(1, 1)),
            of(Numbers("132"), MatchCounts(2, 1)),
            of(Numbers("345"), MatchCounts(1, 0)),
            of(Numbers("234"), MatchCounts(2, 0)),
            of(Numbers("789"), MatchCounts(0, 0))
        )
    }
}
