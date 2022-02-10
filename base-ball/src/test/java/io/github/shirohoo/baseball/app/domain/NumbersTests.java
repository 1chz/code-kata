package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"012", "890", "111", "112", "1234", "1111"})
    void createExceptionWhenNot3NonOverlappingNumbersForUserInput(String userInput) {
        assertThatThrownBy(() -> {
            Numbers randomNumbers = Numbers.nonOverlapping3digits(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
