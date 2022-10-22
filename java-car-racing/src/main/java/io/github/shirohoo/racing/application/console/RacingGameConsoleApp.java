package io.github.shirohoo.racing.application.console;

import io.github.shirohoo.racing.domain.RacingGameRunner;
import io.github.shirohoo.racing.domain.RacingGameSettings;
import io.github.shirohoo.racing.domain.RandomForwardCondition;

public class RacingGameConsoleApp {
    public static void main(String[] args) {
        ConsoleInputAdapter input = new ConsoleInputAdapter();
        ConsoleOutputAdapter output = new ConsoleOutputAdapter();

        output.setCarNamesMessage();
        String carNames = input.carNames();

        output.setTryCountMessage();
        int tryCount = input.tryCount();

        RacingGameSettings settings =
                RacingGameSettings.of(carNames, tryCount, new RandomForwardCondition());
        RacingGameRunner racingGameRunner = RacingGameRunner.from(settings);

        output.showRoundMessage(racingGameRunner);

        output.showResultMessage(racingGameRunner);
    }
}
