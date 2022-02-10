package io.github.shirohoo.baseball.app.domain;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumbersGenerativeStrategyTests {
    @RepeatedTest(100)
    void generate() {
        RandomNumbersGenerativeStrategy strategy = new RandomNumbersGenerativeStrategy();
        String randomNumbers = strategy.generate();

        assertThat(distinctCount(randomNumbers)).isEqualTo(3L);
        assertThat(sum(randomNumbers)).isGreaterThanOrEqualTo(6).isLessThanOrEqualTo(24);
    }

    private long distinctCount(String randomNumbers) {
        return stream(randomNumbers.split(""))
            .distinct()
            .count();
    }

    private int sum(String randomNumbers) {
        return stream(randomNumbers.split(""))
            .mapToInt(Integer::valueOf)
            .sum();
    }
}
