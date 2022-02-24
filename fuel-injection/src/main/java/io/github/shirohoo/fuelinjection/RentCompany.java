package io.github.shirohoo.fuelinjection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {
    private final List<Car> cars;

    public RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream()
            .map(car -> "%s : %s리터%s".formatted(car.getName(), car.getChargeQuantity(), System.lineSeparator()))
            .collect(Collectors.joining());
    }
}
