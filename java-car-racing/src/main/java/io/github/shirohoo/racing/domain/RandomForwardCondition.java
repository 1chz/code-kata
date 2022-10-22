package io.github.shirohoo.racing.domain;

import java.util.random.RandomGenerator;

public class RandomForwardCondition implements ForwardCondition {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    @Override
    public boolean get() {
        int forwardCondition = 4;
        return RANDOM_GENERATOR.nextInt(10) >= forwardCondition;
    }
}