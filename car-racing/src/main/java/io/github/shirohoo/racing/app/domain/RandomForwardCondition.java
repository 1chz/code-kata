package io.github.shirohoo.racing.app.domain;

import java.util.random.RandomGenerator;

public class RandomForwardCondition implements ForwardCondition {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    @Override
    public boolean get() {
        return RANDOM_GENERATOR.nextInt(10) >= 4;
    }
}
