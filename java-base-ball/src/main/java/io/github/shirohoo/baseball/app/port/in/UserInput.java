package io.github.shirohoo.baseball.app.port.in;

import io.github.shirohoo.baseball.app.domain.Numbers;
import java.util.Arrays;
import java.util.stream.Stream;

public class UserInput {
    private final String userInput;

    private UserInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("'userInput' must not be null or empty");
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException("'userInput' must not be contain '0'");
        }

        long count = stream(input).distinct().count();
        if (count != 3) {
            throw new IllegalArgumentException("'userInput' must be three non-overlapping numbers");
        }

        int sum = stream(input).mapToInt(Integer::valueOf).sum();
        if (sum < 6 || sum > 24) {
            throw new IllegalArgumentException("sum of 'userInput' must be 6 <= x <= 24");
        }
        this.userInput = input;
    }

    private Stream<String> stream(String input) {
        return Arrays.stream(input.split(""));
    }

    public static UserInput nonOverlapping3digits(String input) {
        return new UserInput(input);
    }

    public Numbers createNumbers() {
        return Numbers.from(userInput);
    }

}
