package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class NumbersTests {
    @Test
    void from() {
        assertThatCode(() -> {
            Numbers randomNumbers = Numbers.from(() -> "123");
        }).doesNotThrowAnyException();
    }
}
