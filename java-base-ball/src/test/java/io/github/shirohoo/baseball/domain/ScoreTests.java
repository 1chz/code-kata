package io.github.shirohoo.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.shirohoo.domain.Score;
import org.junit.jupiter.api.Test;

class ScoreTests {
    @Test
    void shouldPassIfStrikeCountIs3Then() {
        Score score = new Score(0, 3);
        assertTrue(score.strikeOut());
    }
}
