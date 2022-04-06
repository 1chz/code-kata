package io.github.shirohoo.baseball.usecase

import io.github.shirohoo.baseball.domain.MatchCounts
import io.github.shirohoo.baseball.domain.Numbers
import io.github.shirohoo.baseball.domain.NumbersGenerator
import io.github.shirohoo.baseball.port.`in`.BaseBallPort

class BaseBallUseCase(numbersGenerator: NumbersGenerator) : BaseBallPort {
    private val computerNumbers = numbersGenerator.generate()

    override fun pitching(userNumbers: Numbers): MatchCounts = computerNumbers.compare(userNumbers)
}