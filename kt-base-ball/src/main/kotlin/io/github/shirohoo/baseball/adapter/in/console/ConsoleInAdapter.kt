package io.github.shirohoo.baseball.adapter.`in`.console

import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutAdapter
import io.github.shirohoo.baseball.domain.MatchCounts
import io.github.shirohoo.baseball.domain.Numbers
import io.github.shirohoo.baseball.usecase.BaseBallUseCase

class ConsoleInAdapter(
    private var baseBall: BaseBallUseCase,
    private val consoleOutAdapter: ConsoleOutAdapter,
) {
    fun trys() {
        consoleOutAdapter.printInputGuide()
        val userNumbers: Numbers = readLine()?.let { Numbers(it) } ?: throw IllegalArgumentException("no input !")

        val matchCounts: MatchCounts = baseBall.pitching(userNumbers)

        consoleOutAdapter.printToConsole(matchCounts)

        if (matchCounts.isStrikeOut()) {
            consoleOutAdapter.printComplete()
            throw InterruptedException()
        }
    }
}