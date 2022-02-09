package io.github.shirohoo;

import io.github.shirohoo.baseball.adapter.in.console.ConsoleInput;
import io.github.shirohoo.baseball.adapter.out.console.ConsoleOutput;
import io.github.shirohoo.baseball.app.port.out.TryResult;
import io.github.shirohoo.baseball.app.usecase.UserTry;

public class ConsoleBaseBallApp {
    public static void main(String[] args) {
        Runner.init().run();
    }

    private static class Runner {
        private final UserTry game;
        private final ConsoleInput input;
        private final ConsoleOutput output;

        private Runner() {
            this.game = UserTry.create();
            this.input = new ConsoleInput();
            this.output = new ConsoleOutput();
        }

        private static Runner init() {
            return new Runner();
        }

        private void run() {
            TryResult trys;
            do {
                output.enterNumberMessage();
                trys = game.trys(input.trys());
                output.resultMessage(trys);
            } while (!trys.isStrikeOut());
            output.restartMessage();
            restart(input.restartIntentions());
        }

        private void restart(boolean restart) {
            if (restart) {
                run();
            }
            System.exit(0);
        }
    }
}
