package io.github.shirohoo.lotto;

import java.util.List;
import java.util.Map;

public class LottoConsoleApp {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        output.purchaseAmountMessage();
        int purchaseAmount = input.enterPurchaseAmount();

        output.numbersOfPurchaseMessage(purchaseAmount);
        BuyLottoPort buyLottoPort = new BuyLottoUseCase(new LottoMachine());

        List<NotScratchedLotto> notScratchedLottos = buyLottoPort.buyLotto(purchaseAmount);
        output.printLottos(notScratchedLottos);

        output.winningNumbersMessage();
        WinnerLotto winnerLotto = WinnerLotto.from(input.enterWinningNumbers());

        ScratchPort scratchPort = new ScratchUseCase();
        Map<Integer, List<MatchPrize>> scratched = scratchPort.scratch(winnerLotto, notScratchedLottos);

        CheckResultPort checkResultPort = new CheckResultUseCase();
        Result result = checkResultPort.check(scratched, purchaseAmount);

        output.printResult(result);
    }
}
