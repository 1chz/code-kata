package io.github.shirohoo.lotto;

import static io.github.shirohoo.lotto.Lotto.LOTTO_PRICE;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import java.util.List;
import java.util.function.IntFunction;

public class BuyLottoUseCase implements BuyLottoPort {
    private final LottoMachine lottoMachine;

    public BuyLottoUseCase(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public List<NotScratchedLotto> buyLotto(int purchaseAmount) {
        int numberOfPurchase = purchaseAmount / LOTTO_PRICE;
        return range(0, numberOfPurchase)
            .mapToObj(ticketing())
            .collect(toList());
    }

    private IntFunction<NotScratchedLotto> ticketing() {
        return i -> NotScratchedLotto.from(lottoMachine.ticketing());
    }
}
