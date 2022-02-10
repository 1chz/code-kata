package io.github.shirohoo.baseball.app.domain;

import static java.util.Arrays.stream;

public record Numbers(String numbers) {
    public static Numbers create(NumbersGenerativeStrategy strategy) {
        return new Numbers(strategy.generate());
    }

    public static Numbers nonOverlapping3digits(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("'userInput' must not be null or empty");
        }

        if (userInput.contains("0")) {
            throw new IllegalArgumentException("'userInput' must not be contain '0'");
        }

        long count = stream(userInput.split("")).distinct().count();
        if (count != 3) {
            throw new IllegalArgumentException("'userInput' must be three non-overlapping numbers");
        }

        int sum = stream(userInput.split("")).mapToInt(Integer::valueOf).sum();
        if (sum < 6 || sum > 24) {
            throw new IllegalArgumentException("sum of 'userInput' must be 6 <= x <= 24");
        }
        return new Numbers(userInput);
    }
}
