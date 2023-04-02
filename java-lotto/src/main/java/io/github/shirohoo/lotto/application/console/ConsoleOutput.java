package io.github.shirohoo.lotto.application.console;

import io.github.shirohoo.lotto.domain.Lottos;
import io.github.shirohoo.lotto.domain.MatchPrize;
import io.github.shirohoo.lotto.domain.Statistics;

public class ConsoleOutput {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_CONFIRMATION_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public void printEnterPurchaseAmountMessage() {
        println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseConfirmationMessage(long purchaseOfNumber) {
        printf(PURCHASE_CONFIRMATION_MESSAGE, purchaseOfNumber);
        newLine();
    }

    public void printLottoNumbers(Lottos lottos) {
        println(lottos.stringValue());
    }

    public void printEnterWinningNumbersMessage() {
        newLine();
        println(WINNING_NUMBERS_MESSAGE);
    }

    public void printStatistics(Statistics statistics, long purchaseAmount) {
        newLine();
        printf(
                """
                당첨 통계
                ---------
                3개 일치 (5,000원)- %d개
                4개 일치 (50,000원)- %d개
                5개 일치 (1,500,000원)- %d개
                6개 일치 (2,000,000,000원)- %d개
                총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
                """,
                statistics.countOfWinningLotto(MatchPrize.THREE),
                statistics.countOfWinningLotto(MatchPrize.FOUR),
                statistics.countOfWinningLotto(MatchPrize.FIVE),
                statistics.countOfWinningLotto(MatchPrize.SIX),
                statistics.profitRate(purchaseAmount));
    }

    private void println(String msg) {
        System.out.println(msg);
    }

    private void printf(String msg, Object... objects) {
        System.out.printf(msg, objects);
    }

    private void newLine() {
        println("");
    }
}
