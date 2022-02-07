package io.github.shirohoo.racing.domain;

import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cars {
    private final Collection<Car> cars;

    private Cars(String cars) {
        if (cars == null || cars.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.cars = stream(cars.split(","))
            .map(Car::from)
            .toList();
    }

    public static Cars createCars(String carNames) {
        return new Cars(carNames);
    }

    public List<Car> forward(ForwardCondition condition) {
        cars.forEach(car -> car.forward(condition));
        return new ArrayList<>(cars.stream().map(Car::deepCopy).toList());
    }

    public List<Car> winners() {
        return cars.stream()
            .filter(car -> car.currentPosition() == maxPosition())
            .toList();
    }

    private int maxPosition() {
        return cars.stream()
            .mapToInt(Car::currentPosition)
            .reduce(Integer.MIN_VALUE, Integer::max);
    }
}
