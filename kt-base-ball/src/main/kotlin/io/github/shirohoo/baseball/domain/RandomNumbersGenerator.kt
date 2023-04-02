package io.github.shirohoo.baseball.domain

object RandomNumbersGenerator : NumbersGenerator {
    override fun generate(): Numbers = Numbers(
        generateSequence { (1..9).random() }
            .distinct()
            .take(3)
            .map(Int::toString)
            .joinToString(separator = "")
    )
}
