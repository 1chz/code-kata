package io.github.shirohoo.baseball.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class DecisionResultTests {
    @Test
    void isStrikeOut() {
        DecisionResult result = DecisionResult.of(0, 3);
        assertThat(result.isStrikeOut()).isTrue();
    }
}
