package io.github.shirohoo.racing.port.out;

import io.github.shirohoo.racing.domain.Car;
import java.util.List;

public interface Output {
    String setCarNamesMessage();

    String setTryCountMessage();

    String showRoundMessage(List<List<Car>> eachRound);

    String showResultMessage(List<Car> winners);
}
