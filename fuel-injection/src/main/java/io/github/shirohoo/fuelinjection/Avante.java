package io.github.shirohoo.fuelinjection;

public class Avante extends Car {
    private final int destinationDistance;

    public Avante(int destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 15;
    }

    @Override
    double getTripDistance() {
        return destinationDistance;
    }

    @Override
    String getName() {
        return "Avante";
    }
}
