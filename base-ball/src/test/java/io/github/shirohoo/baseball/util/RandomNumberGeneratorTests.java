package io.github.shirohoo.baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTests {
    @Test
    void threeLetters() {
        String randomNumber = RandomNumberGenerator.threeLetters();
        assertThat(randomNumber.chars().distinct().count()).isEqualTo(3);
    }
}