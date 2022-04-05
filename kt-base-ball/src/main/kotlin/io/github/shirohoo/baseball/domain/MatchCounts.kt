package io.github.shirohoo.baseball.domain

import io.github.shirohoo.baseball.domain.ComparisonResults.*

data class MatchCounts(private val ballCount: Int, private val strikeCount: Int) {
    fun comparisonResult(): ComparisonResults = when {
        (ballCount > 0) and (strikeCount == 0) -> ONLY_BALL
        (ballCount == 0) and (strikeCount > 0) -> ONLY_STRIKE
        (ballCount > 0) and (strikeCount > 0) -> BALL_AND_STRIKE
        (ballCount == 0) and (strikeCount == 0) -> NOTHING
        else -> STRIKE_OUT
    }
}