package io.github.shirohoo.fuelinjection;

public class Sonata extends Car {
    private final int destinationDistance;

    public Sonata(int destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 10;
    }

    @Override
    double getTripDistance() {
        return destinationDistance;
    }

    @Override
    String getName() {
        return "Sonata";
    }
}
