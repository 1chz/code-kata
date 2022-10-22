package io.github.shirohoo.racing.domain;

import java.util.List;

public interface RacingGame {
    List<List<Car>> eachRound();

    List<Car> winners();
}
