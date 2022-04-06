package io.github.shirohoo.baseball.port.`in`

import io.github.shirohoo.baseball.domain.MatchCounts
import io.github.shirohoo.baseball.domain.Numbers

interface BaseBallPort {
    fun pitching(userNumbers: Numbers): MatchCounts
}