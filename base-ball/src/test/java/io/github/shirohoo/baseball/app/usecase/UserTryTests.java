package io.github.shirohoo.baseball.app.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import io.github.shirohoo.baseball.app.port.in.TryCommand;
import io.github.shirohoo.baseball.app.port.out.TryResult;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserTryTests {
    @Test
    void create() {
        assertThatCode(UserTry::create)
            .doesNotThrowAnyException();
    }

    @MethodSource
    @ParameterizedTest
    void action(TryCommand userCommand, TryResult expected) {
        UserTry trys = UserTry.from(TryCommand.from("123"));

        TryResult tryResult = trys.action(userCommand);

        assertThat(tryResult).isEqualTo(expected);
    }

    static Stream<Arguments> action() {
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
