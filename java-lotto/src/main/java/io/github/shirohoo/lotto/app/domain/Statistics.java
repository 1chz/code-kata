package io.github.shirohoo.lotto.app.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class Statistics {
    private final Map<MatchPrize, Long> statistics;

    private Statistics(Map<MatchPrize, Long> statistics) {
        this.statistics = statistics;
    }

    public static Statistics from(Map<MatchPrize, Long> statistics) {
        return new Statistics(statistics);
    }

    public long totalPrize() {
        return statistics.entrySet()
            .stream()
            .map(totalPrizeByRank())
            .mapToLong(Long::valueOf)
            .sum();
    }

    private Function<Entry<MatchPrize, Long>, Long> totalPrizeByRank() {
        return entry -> entry.getKey().prize() * entry.getValue();
    }

    public long countOfWinningLotto(MatchPrize matchPrize) {
        return statistics.getOrDefault(matchPrize, 0L);
    }

    public double profitRate(long purchaseAmount) {
        return totalPrize() / (double) purchaseAmount;
    }
}
