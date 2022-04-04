package io.github.shirohoo.baseball.domain

data class Numbers private constructor(val values: String) {
    companion object {
        operator fun invoke(values: String): Numbers {
            val charSet = values.toSet()
            return when (charSet.size) {
                3    -> Numbers(values)
                else -> throw IllegalStateException("Numbers's values must be three non-overlapping numbers 1 through 9")
            }
        }
    }
}
