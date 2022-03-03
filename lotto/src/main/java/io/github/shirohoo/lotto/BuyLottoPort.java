package io.github.shirohoo.lotto;

import java.util.List;

public interface BuyLottoPort {
    List<NotScratchedLotto> buyLotto(int purchaseAmount);
}
