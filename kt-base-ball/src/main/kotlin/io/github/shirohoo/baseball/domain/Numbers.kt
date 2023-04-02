package io.github.shirohoo.baseball.domain

data class Numbers private constructor(val values: String) {
    fun compare(other: Numbers): MatchCounts {
        var ballCount = 0
        var strikeCount = 0
        return (0..2).forEach {
            when {
                values[it] == other.values[it] -> strikeCount++
                values[it] in other.values -> ballCount++
            }
        }.let { MatchCounts(ballCount, strikeCount) }
    }

    companion object {
        operator fun invoke(values: String): Numbers {
            val charSet = values.toSet()
            return when (charSet.size) {
                3 -> Numbers(values)
                else -> throw IllegalArgumentException("'Numbers' must be three non-overlapping numbers 1 through 9")
            }
        }
    }
}
