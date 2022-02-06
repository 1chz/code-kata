package io.github.shirohoo.racing.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String carName) {
        return new Car(carName);
    }

    public Car deepCopy() {
        return new Car(name, position);
    }

    public int forward(ForwardCondition condition) {
        if (condition.get()) {
            return ++position;
        }
        return position;
    }

    public String name() {
        return name;
    }

    public int currentPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
