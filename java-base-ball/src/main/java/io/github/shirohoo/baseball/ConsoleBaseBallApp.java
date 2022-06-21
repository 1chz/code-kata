package io.github.shirohoo.baseball;

import io.github.shirohoo.baseball.adapter.in.console.ConsoleInput;
import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutput;
import io.github.shirohoo.baseball.app.domain.DecisionResult;
import io.github.shirohoo.baseball.app.domain.RandomNumbersGenerativeStrategy;
import io.github.shirohoo.baseball.app.domain.Referee;
import io.github.shirohoo.baseball.app.port.in.BaseBall;
import io.github.shirohoo.baseball.app.usecase.BaseBallImpl;

public class ConsoleBaseBallApp {
    public static void main(String[] args) {
        Runner.init().run();
    }

    private static class Runner {
        private static Runner init() {
            return new Runner();
        }

        private void run() {
            ConsoleInput input = new ConsoleInput();
            ConsoleOutput output = new ConsoleOutput();
            BaseBall game = BaseBallImpl.of(new Referee(), new RandomNumbersGenerativeStrategy());

            DecisionResult result;
            do {
                output.enterNumberMessage();
                result = game.action(input.trys());
                output.resultMessage(result);
            } while (!result.isStrikeOut());

            output.restartMessage();
            if (input.restartIntentions()) {
                run();
            }
            System.exit(0);
        }
    }
}
