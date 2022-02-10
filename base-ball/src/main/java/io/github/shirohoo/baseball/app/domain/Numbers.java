package io.github.shirohoo.baseball.app.domain;

public record Numbers(String numbers) {
    public static Numbers create(NumbersGenerativeStrategy strategy) {
        return new Numbers(strategy.generate());
    }
}
