package io.github.shirohoo.baseball.util;

import static java.util.stream.Collectors.joining;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public abstract class RandomNumberGenerator {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create();

    public static String threeLetters() {
        return RANDOM_GENERATOR.ints(1, 10)
            .distinct()
            .limit(3)
            .mapToObj(String::valueOf)
            .collect(joining());
    }
}
