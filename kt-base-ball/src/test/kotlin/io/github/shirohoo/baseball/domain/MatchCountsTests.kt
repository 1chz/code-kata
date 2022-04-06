package io.github.shirohoo.baseball.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MatchCountsTests {
    @ParameterizedTest
    @MethodSource("testCases")
    fun `0볼 3스트라이크면 참을 반환한다`(matchCounts: MatchCounts, expected: Boolean) {
        assertEquals(expected, matchCounts.isStrikeOut())
    }

    companion object {
        @JvmStatic
        fun testCases(): Stream<Arguments> = Stream.of(
            of(MatchCounts(0, 3), true),
            of(MatchCounts(0, 2), false),
            of(MatchCounts(1, 2), false),
            of(MatchCounts(0, 1), false),
            of(MatchCounts(1, 1), false),
            of(MatchCounts(2, 1), false),
            of(MatchCounts(0, 0), false),
            of(MatchCounts(1, 0), false),
            of(MatchCounts(2, 0), false),
            of(MatchCounts(3, 0), false)
        )
    }
}