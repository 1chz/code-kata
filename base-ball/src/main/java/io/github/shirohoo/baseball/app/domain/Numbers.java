package io.github.shirohoo.baseball.app.domain;

import io.github.shirohoo.baseball.app.port.in.TryCommand;
import io.github.shirohoo.baseball.app.port.out.TryResult;
import io.github.shirohoo.baseball.util.RandomNumberGenerator;
import java.util.Objects;

public class Numbers {
    private final String numbers;

    private Numbers(String numbers) {
        if (numbers == null ||
            numbers.isBlank() ||
            numbers.length() != 3 ||
            numbers.chars().distinct().count() != 3
        ) {
            throw new IllegalArgumentException("number must not be null, empty, not 3 length, duplicate");
        }

        this.numbers = numbers;
    }

    public static Numbers threeLetters() {
        return new Numbers(RandomNumberGenerator.threeLetters());
    }

    public static Numbers from(TryCommand command) {
        return new Numbers(command.value());
    }

    public TryResult match(Numbers userNumber) {
        return computed(userNumber);
    }

    private TryResult computed(Numbers userNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < length(); i++) {
            ballCount += ifBallIncreaseByOne(userNumber, i);
            strikeCount += ifStrikeIncreaseByOne(userNumber, i);
        }
        return TryResult.of(ballCount, strikeCount);
    }

    private int ifBallIncreaseByOne(Numbers userNumber, int i) {
        if (numbers.charAt(i) != userNumber.numbers.charAt(i) &&
            userNumber.numbers.contains(Character.toString(numbers.charAt(i)))
        ) {
            return 1;
        }
        return 0;
    }

    private int ifStrikeIncreaseByOne(Numbers userNumber, int i) {
        if (numbers.charAt(i) == userNumber.numbers.charAt(i)) {
            return 1;
        }
        return 0;
    }

    private int length() {
        return numbers.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) o;
        return Objects.equals(this.numbers, numbers.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
