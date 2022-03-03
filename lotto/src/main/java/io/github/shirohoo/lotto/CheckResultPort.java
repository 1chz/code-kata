package io.github.shirohoo.lotto;

import java.util.List;
import java.util.Map;

public interface CheckResultPort {
    Result check(Map<Integer, List<MatchPrize>> result, long purchaseAmount);
}
