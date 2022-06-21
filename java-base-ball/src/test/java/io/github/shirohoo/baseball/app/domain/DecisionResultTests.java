package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class DecisionResultTests {
    @Test
    void isBallAndStrike() {
        DecisionResult result = DecisionResult.of(1, 1);
        assertThat(result.isBallAndStrike()).isTrue();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.isOnlyBall()).isFalse();
        assertThat(result.isOnlyStrike()).isFalse();
        assertThat(result.isStrikeOut()).isFalse();
    }

    @Test
    void isNothing() {
        DecisionResult result = DecisionResult.of(0, 0);
        assertThat(result.isBallAndStrike()).isFalse();
        assertThat(result.isNothing()).isTrue();
        assertThat(result.isOnlyBall()).isFalse();
        assertThat(result.isOnlyStrike()).isFalse();
        assertThat(result.isStrikeOut()).isFalse();
    }

    @Test
    void isOnlyBall() {
        DecisionResult result = DecisionResult.of(1, 0);
        assertThat(result.isBallAndStrike()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.isOnlyBall()).isTrue();
        assertThat(result.isOnlyStrike()).isFalse();
        assertThat(result.isStrikeOut()).isFalse();
    }

    @Test
    void isOnlyStrike() {
        DecisionResult result = DecisionResult.of(0, 1);
        assertThat(result.isBallAndStrike()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.isOnlyBall()).isFalse();
        assertThat(result.isOnlyStrike()).isTrue();
        assertThat(result.isStrikeOut()).isFalse();
    }

    @Test
    void isStrikeOut() {
        DecisionResult result = DecisionResult.of(0, 3);
        assertThat(result.isBallAndStrike()).isFalse();
        assertThat(result.isNothing()).isFalse();
        assertThat(result.isOnlyBall()).isFalse();
        assertThat(result.isOnlyStrike()).isTrue();
        assertThat(result.isStrikeOut()).isTrue();
    }
}
