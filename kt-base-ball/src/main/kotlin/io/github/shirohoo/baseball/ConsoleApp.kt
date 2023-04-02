package io.github.shirohoo.baseball

import io.github.shirohoo.baseball.adapter.`in`.console.ConsoleInAdapter
import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutAdapter
import io.github.shirohoo.baseball.domain.RandomNumbersGenerator
import io.github.shirohoo.baseball.usecase.BaseBallUseCase
import kotlin.system.exitProcess

fun main() {
    val baseBallUseCase = BaseBallUseCase(RandomNumbersGenerator)
    val consoleOutAdapter = ConsoleOutAdapter()
    val consoleInAdapter = ConsoleInAdapter(baseBallUseCase, consoleOutAdapter)

    while (true) {
        try {
            consoleInAdapter.trys()
        } catch (e: InterruptedException) {
            exitProcess(0)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
