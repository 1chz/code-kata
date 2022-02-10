package io.github.shirohoo.baseball.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.baseball.app.domain.Numbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTests {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"012", "890", "111", "112", "1234", "1111"})
    void createExceptionWhenNot3NonOverlappingNumbersForUserInput(String userInput) {
        assertThatThrownBy(() -> {
            UserInput userNumbers = UserInput.nonOverlapping3digits(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createNumbers() {
        UserInput userInput = UserInput.nonOverlapping3digits("123");
        assertThat(userInput.createNumbers()).isEqualTo(Numbers.from("123"));
    }
}
