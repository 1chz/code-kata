package io.github.shirohoo.domain;

public record Score(int ballCount, int strikeCount) {
    public boolean strikeOut() {
        return this.strikeCount == 3;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "nothing";
        }
        if (ballCount > 0 && strikeCount == 0) {
            return "%d balls".formatted(ballCount);
        }
        if (ballCount == 0 && strikeCount > 0) {
            return "%d strikes".formatted(strikeCount);
        }
        return "%d balls %d strikes".formatted(ballCount, strikeCount);
    }
}
