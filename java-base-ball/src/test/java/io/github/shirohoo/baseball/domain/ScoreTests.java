package io.github.shirohoo.baseball.domain;

import io.github.shirohoo.domain.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreTests {
    @Test
    void 스트라이크가_3개면_참을_반환한다() {
        Score score = new Score(0, 3);
        assertTrue(score.strikeOut());
    }
}