package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class NumbersTests {
    @Test
    void create() {
        NumbersGenerativeStrategy randomStrategy = new RandomNumbersGenerativeStrategy();
        assertThatCode(() -> {
            Numbers randomNumbers = Numbers.create(randomStrategy);
        }).doesNotThrowAnyException();
    }
}
