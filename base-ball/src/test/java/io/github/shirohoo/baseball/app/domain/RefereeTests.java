package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RefereeTests {
    @MethodSource
    @ParameterizedTest
    void decision(Numbers userNumbers, DecisionResult expected) {
        Referee referee = new Referee();
        Numbers computerNumbers = Numbers.nonOverlapping3digits("123");

        DecisionResult decisionResult = referee.decision(computerNumbers, userNumbers);

        assertThat(decisionResult).isEqualTo(expected);
    }

    static Stream<Arguments> decision() {
        return Stream.of(
            Arguments.of(Numbers.nonOverlapping3digits("123"), DecisionResult.of(0, 3)),
            Arguments.of(Numbers.nonOverlapping3digits("124"), DecisionResult.of(0, 2)),
            Arguments.of(Numbers.nonOverlapping3digits("145"), DecisionResult.of(0, 1)),
            Arguments.of(Numbers.nonOverlapping3digits("135"), DecisionResult.of(1, 1)),
            Arguments.of(Numbers.nonOverlapping3digits("132"), DecisionResult.of(2, 1)),
            Arguments.of(Numbers.nonOverlapping3digits("345"), DecisionResult.of(1, 0)),
            Arguments.of(Numbers.nonOverlapping3digits("234"), DecisionResult.of(2, 0)),
            Arguments.of(Numbers.nonOverlapping3digits("789"), DecisionResult.of(0, 0))
        );
    }
}
