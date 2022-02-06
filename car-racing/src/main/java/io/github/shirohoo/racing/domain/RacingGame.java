package io.github.shirohoo.racing.domain;

import static java.util.stream.IntStream.rangeClosed;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final ForwardCondition condition;
    private final int tryCount;

    private RacingGame(RacingGameSettings settings) {
        Objects.requireNonNull(settings);
        this.cars = Cars.createCars(settings.carNames());
        this.condition = settings.condition();
        this.tryCount = settings.tryCount();
    }

    public static RacingGame from(RacingGameSettings settings) {
        return new RacingGame(settings);
    }

    public List<List<Car>> eachRound() {
        return rangeClosed(1, tryCount)
            .mapToObj(i -> cars.forward(condition))
            .toList();
    }

    public List<Car> winners() {
        return cars.winners();
    }
}
