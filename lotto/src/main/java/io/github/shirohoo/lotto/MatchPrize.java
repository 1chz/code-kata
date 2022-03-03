package io.github.shirohoo.lotto;

import static java.util.Arrays.stream;

public enum MatchPrize {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    NOT(-1, -1);

    private final int matchCount;
    private final long prize;

    MatchPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static MatchPrize matches(int matchCount) {
        return stream(values())
            .filter(matchPrize -> matchPrize.getMatchCount() == matchCount)
            .findFirst()
            .orElse(NOT);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}
