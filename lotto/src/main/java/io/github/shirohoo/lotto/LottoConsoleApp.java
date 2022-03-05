package io.github.shirohoo.lotto;

import io.github.shirohoo.lotto.adapter.in.console.ConsoleInput;
import io.github.shirohoo.lotto.adapter.out.console.ConsoleOutput;
import io.github.shirohoo.lotto.app.domain.Lotto;
import io.github.shirohoo.lotto.app.domain.LottoMachine;
import io.github.shirohoo.lotto.app.domain.Lottos;

public class LottoConsoleApp {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();
        LottoMachine lottoMachine = new LottoMachine();

        output.printEnterPurchaseAmountMessage();
        long purchaseAmount = input.enterPurchaseAmount();

        long purchaseOfNumber = purchaseAmount / Lotto.PRICE;
        output.printPurchaseConfirmationMessage(purchaseOfNumber);

        Lottos lottos = lottoMachine.ticketing(purchaseOfNumber);
        output.printLottoNumbers(lottos);

        output.printEnterWinningNumbersMessage();
        String winningNumbers = input.enterWinningNumbers();

        Lotto winningLotto = lottoMachine.ticketing(winningNumbers);
        output.printStatistics(lottos.drawn(winningLotto), purchaseAmount);
    }
}
