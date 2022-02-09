package io.github.shirohoo.baseball.app.port.out;

public record TryResult(int ballCount, int strikeCount) {
    public static TryResult of(int ballCount, int strikeCount) {
        return new TryResult(ballCount, strikeCount);
    }

    public boolean isStrikeOut() {
        return strikeCount == 3;
    }
}
