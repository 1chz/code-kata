package io.github.shirohoo.baseball.app.domain;

public class Numbers {
    private final String numbers;

    private Numbers(String numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(NumbersGenerativeStrategy strategy) {
        return new Numbers(strategy.generate());
    }
}
