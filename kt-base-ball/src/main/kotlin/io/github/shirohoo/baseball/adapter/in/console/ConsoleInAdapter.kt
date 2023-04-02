package io.github.shirohoo.baseball.adapter.`in`.console

import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutAdapter
import io.github.shirohoo.baseball.domain.Numbers
import io.github.shirohoo.baseball.usecase.BaseBallUseCase

class ConsoleInAdapter(
    private var baseBall: BaseBallUseCase,
    private val consoleOutAdapter: ConsoleOutAdapter
) {
    fun trys() {
        consoleOutAdapter.inputGuide()
        val userNumbers = readLine()?.let { Numbers(it) } ?: throw IllegalArgumentException("no input !")

        val matchCounts = baseBall.pitching(userNumbers)

        consoleOutAdapter.printFor(matchCounts)

        if (matchCounts.isStrikeOut()) {
            consoleOutAdapter.completeMessage()
            throw InterruptedException("game over")
        }
    }
}
