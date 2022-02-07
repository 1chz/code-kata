package io.github.shirohoo.racing.app.port.out;

import io.github.shirohoo.racing.app.domain.Car;
import java.util.List;

public interface RacingGame {
    List<List<Car>> eachRound();

    List<Car> winners();
}
