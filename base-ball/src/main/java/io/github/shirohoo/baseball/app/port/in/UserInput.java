package io.github.shirohoo.baseball.app.port.in;

import static java.util.Arrays.stream;
import io.github.shirohoo.baseball.app.domain.Numbers;

public class UserInput {
    private final String userInput;

    private UserInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("'userInput' must not be null or empty");
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException("'userInput' must not be contain '0'");
        }

        long count = stream(input.split("")).distinct().count();
        if (count != 3) {
            throw new IllegalArgumentException("'userInput' must be three non-overlapping numbers");
        }

        int sum = stream(input.split("")).mapToInt(Integer::valueOf).sum();
        if (sum < 6 || sum > 24) {
            throw new IllegalArgumentException("sum of 'userInput' must be 6 <= x <= 24");
        }
        this.userInput = input;
    }

    public static UserInput nonOverlapping3digits(String input) {
        return new UserInput(input);
    }

    public Numbers createNumbers() {
        return Numbers.from(userInput);
    }
}
