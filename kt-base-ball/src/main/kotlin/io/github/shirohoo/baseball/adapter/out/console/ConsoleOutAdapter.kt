package io.github.shirohoo.baseball.adapter.out.console

import io.github.shirohoo.baseball.domain.MatchCounts

class ConsoleOutAdapter {
    fun inputGuide() {
        print("숫자를 입력해 주세요 : ")
    }

    fun printFor(matchCounts: MatchCounts) {
        println(getMessage(matchCounts))
    }

    fun completeMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun getMessage(matchCounts: MatchCounts): String = with(matchCounts) {
        when {
            (ballCount > 0) and (strikeCount > 0) -> "${ballCount}볼 ${strikeCount}스트라이크"
            (ballCount > 0) and (strikeCount == 0) -> "${ballCount}볼"
            (ballCount == 0) and (strikeCount > 0) -> "${strikeCount}스트라이크"
            (ballCount == 0) and (strikeCount == 0) -> "낫싱"
            else -> "${strikeCount}스트라이크"
        }
    }
}
