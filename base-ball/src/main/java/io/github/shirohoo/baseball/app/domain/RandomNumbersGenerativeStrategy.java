package io.github.shirohoo.baseball.app.domain;

import static java.util.stream.Collectors.joining;
import java.util.random.RandomGenerator;

public class RandomNumbersGenerativeStrategy implements NumbersGenerativeStrategy {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    public String generate() {
        return RANDOM_GENERATOR.ints(1, 10)
            .distinct()
            .limit(3)
            .mapToObj(String::valueOf)
            .collect(joining());
    }
}
