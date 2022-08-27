package io.github.shirohoo.domain;

import static java.util.stream.Collectors.joining;

import java.util.Objects;
import java.util.random.RandomGenerator;

public final class Numbers {
    private final String val;

    public Numbers() {
        this(
                RandomGenerator.getDefault()
                        .ints(1, 10)
                        .distinct()
                        .limit(3)
                        .mapToObj(String::valueOf)
                        .collect(joining()));
    }

    public Numbers(String val) {
        if (val == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다");
        }
        if (val.length() != 3) {
            throw new IllegalArgumentException("입력된 값이 3글자가 아닙니다");
        }
        if (val.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("입력에 중복된 값이 있습니다");
        }
        this.val = val;
    }

    public Score compareTo(Numbers other) {
        if (other == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다");
        }

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
                if (that[j] == self[i]) {
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
        return "Numbers[" + "val=" + val + ']';
    }
}
