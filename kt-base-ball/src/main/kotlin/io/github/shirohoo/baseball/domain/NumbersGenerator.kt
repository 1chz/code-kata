package io.github.shirohoo.baseball.domain

import java.util.random.RandomGenerator
import kotlin.streams.asSequence

object NumbersGenerator {
    fun generate(): Numbers = Numbers(
        generateRangeRandomSequence(1, 10)
            .distinct()
            .take(3)
            .map(Int::toString)
            .reduce { acc, string -> acc + string })

    private fun generateRangeRandomSequence(start: Int, exclusiveEnd: Int): Sequence<Int> =
        RandomGenerator.getDefault()
            .ints(start, exclusiveEnd)
            .asSequence()
}
