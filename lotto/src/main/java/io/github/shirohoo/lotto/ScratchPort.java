package io.github.shirohoo.lotto;

import java.util.List;
import java.util.Map;

public interface ScratchPort {
    Map<Integer, List<MatchPrize>> scratch(WinnerLotto winnerLotto, List<NotScratchedLotto> notScratchedLottos);
}
