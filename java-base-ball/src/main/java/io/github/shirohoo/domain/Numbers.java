package io.github.shirohoo.domain;

import static java.util.stream.Collectors.joining;

import java.util.Objects;
import java.util.random.RandomGenerator;

public final class Numbers {
    private final String val;

    public Numbers() {
        this(RandomGenerator.getDefault()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .mapToObj(String::valueOf)
                .collect(joining()));
    }

    public Numbers(String val) {
        if (val == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        if (val.length() != 3) {
            throw new IllegalArgumentException("The entered value is not 3 characters long");
        }
        if (val.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("Input has duplicate values");
        }
        this.val = val;
    }

    public Score compareTo(Numbers other) {
        Objects.requireNonNull(other, "input cannot be null");

        char[] self = val.toCharArray();
        char[] that = other.val.toCharArray();

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (self[i] == that[i]) {
                strikeCount++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (self[i] == that[j]) {
                    ballCount++;
                    break;
                }
            }
        }
        return new Score(ballCount, strikeCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Numbers) obj;
        return Objects.equals(this.val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "Numbers[val=%s]".formatted(val);
    }
}
