package io.github.shirohoo;

import io.github.shirohoo.racing.adapter.in.console.ConsoleInputAdapter;
import io.github.shirohoo.racing.adapter.out.console.ConsoleOutputAdapter;
import io.github.shirohoo.racing.app.domain.RacingGameSettings;
import io.github.shirohoo.racing.app.domain.RandomForwardCondition;
import io.github.shirohoo.racing.app.usecase.RacingGameRunner;

public class RacingGameConsoleApp {
    public static void main(String[] args) {
        ConsoleInputAdapter input = new ConsoleInputAdapter();
        ConsoleOutputAdapter output = new ConsoleOutputAdapter();

        output.setCarNamesMessage();
        String carNames = input.carNames();

        output.setTryCountMessage();
        int tryCount = input.tryCount();

        RacingGameSettings settings = RacingGameSettings.of(carNames, tryCount, new RandomForwardCondition());
        RacingGameRunner racingGameRunner = RacingGameRunner.from(settings);

        output.showRoundMessage(racingGameRunner);

        output.showResultMessage(racingGameRunner);
    }
}
