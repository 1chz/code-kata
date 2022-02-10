package io.github.shirohoo.baseball.app.domain;

public record Numbers(String numbers) {
    public static Numbers from(NumbersGenerativeStrategy strategy) {
        return new Numbers(strategy.generate());
    }

    public static Numbers from(String input) {
        return new Numbers(input);
    }
}
