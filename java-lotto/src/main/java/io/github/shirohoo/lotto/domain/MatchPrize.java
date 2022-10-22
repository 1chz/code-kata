package io.github.shirohoo.lotto.domain;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;

public enum MatchPrize {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    TWO(2, 0),
    ONE(1, 0),
    ZERO(0, 0);

    private static final Map<Integer, MatchPrize> map;

    static {
        Collector<MatchPrize, Object, Map<Integer, MatchPrize>> collector =
                collectingAndThen(
                        toMap(MatchPrize::matchCount, identity()), Collections::unmodifiableMap);

        map = stream(values()).collect(collector);
    }

    private final int matchCount;
    private final int prize;

    MatchPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static MatchPrize findByMatchCount(int matchCount) {
        int minMatchCount = 0;
        int maxMatchCount = 6;
        if (matchCount < minMatchCount || matchCount > maxMatchCount) {
            throw new IllegalArgumentException();
        }
        return map.getOrDefault(matchCount, MatchPrize.ZERO);
    }

    public int matchCount() {
        return matchCount;
    }

    public int prize() {
        return prize;
    }
}
