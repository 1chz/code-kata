package io.github.shirohoo.lotto;

import java.util.List;
import java.util.Map;

public class CheckResultUseCase implements CheckResultPort {
    @Override
    public Result check(Map<Integer, List<MatchPrize>> result, long purchaseAmount) {
        return Result.of(result, purchaseAmount);
    }
}
