package io.github.shirohoo.lotto;

import static java.util.stream.Collectors.groupingBy;
import java.util.List;
import java.util.Map;

public class ScratchUseCase implements ScratchPort {
    @Override
    public Map<Integer, List<MatchPrize>> scratch(WinnerLotto winnerLotto, List<NotScratchedLotto> notScratchedLottos) {
        return notScratchedLottos.stream()
            .map(notScratchedLotto -> notScratchedLotto.scratch(winnerLotto))
            .map(scratchedLotto -> MatchPrize.matches(scratchedLotto.getMatchCount()))
            .collect(groupingBy(MatchPrize::getMatchCount));
    }
}
