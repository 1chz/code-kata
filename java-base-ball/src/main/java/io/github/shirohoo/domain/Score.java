package io.github.shirohoo.domain;

public record Score(int ballCount, int strikeCount) {
    public boolean strikeOut() {
        return this.strikeCount == 3;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount > 0 && strikeCount == 0) {
            return "%s볼".formatted(ballCount);
        }
        if (ballCount == 0 && strikeCount > 0) {
            return "%s스트라이크".formatted(strikeCount);
        }
        return "%s볼 %s스트라이크".formatted(ballCount, strikeCount);
    }
}
