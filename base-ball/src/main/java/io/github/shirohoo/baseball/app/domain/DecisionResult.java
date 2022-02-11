package io.github.shirohoo.baseball.app.domain;

public record DecisionResult(int ballCount, int strikeCount) {
    public static DecisionResult of(int ballCount, int strikeCount) {
        return new DecisionResult(ballCount, strikeCount);
    }

    public boolean isBallAndStrike() {
        return ballCount() > 0 && strikeCount() > 0;
    }

    public boolean isNothing() {
        return ballCount() == 0 && strikeCount() == 0;
    }

    public boolean isOnlyBall() {
        return ballCount() > 0 && strikeCount() == 0;
    }

    public boolean isOnlyStrike() {
        return ballCount() == 0 && strikeCount() > 0;
    }

    public boolean isStrikeOut() {
        return strikeCount == 3;
    }
}

