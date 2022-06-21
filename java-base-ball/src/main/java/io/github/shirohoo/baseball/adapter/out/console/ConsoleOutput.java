package io.github.shirohoo.baseball.adapter.out.console;

import io.github.shirohoo.baseball.app.domain.DecisionResult;

public class ConsoleOutput {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void enterNumberMessage() {
        print(ENTER_NUMBER_MESSAGE);
    }

    public void resultMessage(DecisionResult result) {
        if (result.isBallAndStrike()) {
            println(result.ballCount() + BALL_MESSAGE + " " + result.strikeCount() + STRIKE_MESSAGE);
            return;
        }

        if (result.isNothing()) {
            println(NOTHING_MESSAGE);
            return;
        }

        if (result.isOnlyBall()) {
            println(result.ballCount() + BALL_MESSAGE);
            return;
        }

        if (result.isOnlyStrike()) {
            println(result.strikeCount() + STRIKE_MESSAGE);
            if (result.isStrikeOut()) {
                println(COMPLETE_MESSAGE);
            }
        }
    }

    public void restartMessage() {
        println(RESTART_MESSAGE);
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
