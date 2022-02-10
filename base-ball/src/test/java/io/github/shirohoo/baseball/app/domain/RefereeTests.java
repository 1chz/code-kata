package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.shirohoo.baseball.app.port.in.UserInput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RefereeTests {
    @MethodSource
    @ParameterizedTest
    void decision(UserInput userInput, DecisionResult expected) {
        Referee referee = new Referee();
        Numbers computerNumbers = Numbers.from("123");

        DecisionResult decisionResult = referee.decision(computerNumbers, userInput.createNumbers());

        assertThat(decisionResult).isEqualTo(expected);
    }

    static Stream<Arguments> decision() {
        return Stream.of(
            Arguments.of(UserInput.nonOverlapping3digits("123"), DecisionResult.of(0, 3)),
            Arguments.of(UserInput.nonOverlapping3digits("124"), DecisionResult.of(0, 2)),
            Arguments.of(UserInput.nonOverlapping3digits("145"), DecisionResult.of(0, 1)),
            Arguments.of(UserInput.nonOverlapping3digits("135"), DecisionResult.of(1, 1)),
            Arguments.of(UserInput.nonOverlapping3digits("132"), DecisionResult.of(2, 1)),
            Arguments.of(UserInput.nonOverlapping3digits("345"), DecisionResult.of(1, 0)),
            Arguments.of(UserInput.nonOverlapping3digits("234"), DecisionResult.of(2, 0)),
            Arguments.of(UserInput.nonOverlapping3digits("789"), DecisionResult.of(0, 0))
        );
    }
}
