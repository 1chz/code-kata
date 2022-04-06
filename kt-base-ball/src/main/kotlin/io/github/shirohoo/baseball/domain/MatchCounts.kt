package io.github.shirohoo.baseball.domain

data class MatchCounts(val ballCount: Int, val strikeCount: Int) {
    fun isStrikeOut(): Boolean = ballCount == 0 && strikeCount == 3
}