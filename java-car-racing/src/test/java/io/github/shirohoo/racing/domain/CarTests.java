package io.github.shirohoo.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTests {
    @Test
    void createCar() {
        String carName = "junny";
        assertThatCode(() -> {
                    Car car = Car.from(carName);
                    assertThat(car).isNotNull();
                })
                .doesNotThrowAnyException();
    }

    @Test
    void createCarNameExceptionIfNameLengthGreaterThenFive() {
        String carName = "abcdef";
        assertThatThrownBy(() -> {
                    Car car = Car.from(carName);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void createCarExceptionIfNameNullOrEmpty(String carName) {
        assertThatThrownBy(() -> {
                    Car car = Car.from(carName);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void deepCopy() {
        // ...given
        Car car = Car.from("junny");

        // ...when
        Car copiedCar = car.deepCopy();

        // ...then
        assertThat((car != copiedCar)).isTrue();
    }

    @MethodSource
    @ParameterizedTest
    void forward(ForwardCondition condition, int expected) {
        // ...given
        Car car = Car.from("junny");

        // ...when
        int currentPosition = car.forward(condition);

        // ...then
        assertThat(currentPosition).isEqualTo(expected);
    }

    static Stream<Arguments> forward() {
        return Stream.of(
                Arguments.of((ForwardCondition) () -> true, 1), Arguments.of((ForwardCondition) () -> false, 0));
    }

    @Test
    void name() {
        // ...given
        Car car = Car.from("junny");

        // ...when
        String carName = car.name();

        // ...then
        assertThat(carName).isEqualTo("junny");
    }

    @Test
    void currentPosition() {
        // ...given
        Car car = Car.from("junny");

        // ...when
        int currentPosition = car.currentPosition();

        // ...then
        assertThat(currentPosition).isEqualTo(0);
    }

    @Test
    void currentPositionIncremented() {
        // ...given
        Car car = Car.from("junny");
        car.forward(() -> true);

        // ...when
        int currentPosition = car.currentPosition();

        // ...then
        assertThat(currentPosition).isEqualTo(1);
    }
}
