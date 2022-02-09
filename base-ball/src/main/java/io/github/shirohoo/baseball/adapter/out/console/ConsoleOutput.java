package io.github.shirohoo.baseball.adapter.out.console;

import io.github.shirohoo.baseball.app.port.out.TryResult;

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

    public void resultMessage(TryResult tryResult) {
        if (tryResult.ballCount() == 0 && tryResult.strikeCount() == 0) {
            println(NOTHING_MESSAGE);
        }
        if (tryResult.ballCount() > 0 && tryResult.strikeCount() == 0) {
            println(tryResult.ballCount() + BALL_MESSAGE);
        }
        if (tryResult.ballCount() == 0 && tryResult.strikeCount() > 0) {
            println(tryResult.strikeCount() + STRIKE_MESSAGE);
        }
        if (tryResult.ballCount() > 0 && tryResult.strikeCount() > 0) {
            println(String.format("%s%s %s%s",
                tryResult.ballCount(), BALL_MESSAGE,
                tryResult.strikeCount(), STRIKE_MESSAGE
            ));
        }
        if (tryResult.strikeCount() == 3) {
            println(COMPLETE_MESSAGE);
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
