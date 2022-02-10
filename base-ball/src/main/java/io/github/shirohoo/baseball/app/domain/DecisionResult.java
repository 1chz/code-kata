package io.github.shirohoo.baseball.app.domain;

public record DecisionResult(int ballCount, int strikeCount) {
    public static DecisionResult of(int ballCount, int strikeCount) {
        return new DecisionResult(ballCount, strikeCount);
    }

    public boolean isStrikeOut() {
        return strikeCount == 3;
    }
}

