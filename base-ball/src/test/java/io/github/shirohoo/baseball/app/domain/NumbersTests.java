package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class NumbersTests {
    @Test
    void create() {
        NumbersGenerativeStrategy randomStrategy = new RandomNumbersGenerativeStrategy();
        assertThatCode(() -> {
            Numbers randomNumbers = Numbers.create(randomStrategy);
        }).doesNotThrowAnyException();
    }

    @Test
    void createExceptionWhenInNull() {
        assertThatThrownBy(() -> {
            Numbers randomNumbers = Numbers.create(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
