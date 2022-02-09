package io.github.shirohoo;

import io.github.shirohoo.baseball.adapter.in.console.ConsoleInput;
import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutput;
import io.github.shirohoo.baseball.app.port.in.Try;
import io.github.shirohoo.baseball.app.port.out.TryResult;
import io.github.shirohoo.baseball.app.usecase.UserTry;

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

            Try trys = UserTry.create();

            TryResult result;
            do {
                output.enterNumberMessage();
                result = trys.action(input.trys());
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
