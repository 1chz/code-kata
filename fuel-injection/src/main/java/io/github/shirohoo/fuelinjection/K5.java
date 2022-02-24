package io.github.shirohoo.fuelinjection;

public class K5 extends Car {
    private final int destinationDistance;

    public K5(int destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    @Override
    double getDistancePerLiter() {
        return 13;
    }

    @Override
    double getTripDistance() {
        return destinationDistance;
    }

    @Override
    String getName() {
        return "K5";
    }
}
