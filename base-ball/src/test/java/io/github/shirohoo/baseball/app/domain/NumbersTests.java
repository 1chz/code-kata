package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.baseball.app.port.in.TryCommand;
import io.github.shirohoo.baseball.app.port.out.TryResult;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTests {
    @Test
    void create() {
        assertThatCode(Numbers::threeLetters)
            .doesNotThrowAnyException();
    }

    @Test
    void createFrom() {
        TryCommand command = TryCommand.from("123");
        assertThatCode(() -> {
            Numbers.from(command);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1234", "111", "112"})
    void createExceptions(String value) {
        TryCommand command = TryCommand.from(value);
        assertThatThrownBy(() -> {
            Numbers.from(command);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("number must not be null, empty, not 3 length, duplicate");
    }

    @MethodSource
    @ParameterizedTest
    void match(TryCommand userCommand, TryResult expected) {
        Numbers computersNumber = Numbers.from(TryCommand.from("123"));
        Numbers userNumber = Numbers.from(userCommand);

        TryResult tryResult = computersNumber.match(userNumber);

        assertThat(tryResult).isEqualTo(expected);
    }

    static Stream<Arguments> match() {
        return Stream.of(
            Arguments.of(TryCommand.from("123"), TryResult.of(0, 3)),
            Arguments.of(TryCommand.from("124"), TryResult.of(0, 2)),
            Arguments.of(TryCommand.from("145"), TryResult.of(0, 1)),
            Arguments.of(TryCommand.from("135"), TryResult.of(1, 1)),
            Arguments.of(TryCommand.from("132"), TryResult.of(2, 1)),
            Arguments.of(TryCommand.from("345"), TryResult.of(1, 0)),
            Arguments.of(TryCommand.from("234"), TryResult.of(2, 0)),
            Arguments.of(TryCommand.from("789"), TryResult.of(0, 0))
        );
    }
}