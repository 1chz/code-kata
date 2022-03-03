package io.github.shirohoo.lotto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public record Result(Map<Integer, List<MatchPrize>> result, long purchaseAmount) {
    public static Result of(Map<Integer, List<MatchPrize>> result, long purchaseAmount) {
        return new Result(result, purchaseAmount);
    }

    public int matchCount(int key) {
        List<MatchPrize> matchPrizes = result.get(key);
        if (matchPrizes == null) {
            return 0;
        }
        return matchPrizes.size();
    }

    public double profitRate() {
        long totalPrize = result.values().stream()
            .flatMap(Collection::stream)
            .map(MatchPrize::getPrize)
            .reduce(0L, Long::sum);

        return totalPrize / (double) purchaseAmount;
    }
}
