package io.github.shirohoo.lotto;

import static io.github.shirohoo.lotto.Lotto.LOTTO_PRICE;
import java.util.List;

public class ConsoleOutput {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBERS_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public void purchaseAmountMessage() {
        println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void numbersOfPurchaseMessage(int purchaseAmount) {
        println(NUMBERS_OF_PURCHASE_MESSAGE.formatted(purchaseAmount / LOTTO_PRICE));
    }

    public void printLottos(List<NotScratchedLotto> lottos) {
        lottos.forEach(System.out::println);
        emptyLine();
    }

    public void winningNumbersMessage() {
        println(WINNING_NUMBERS_MESSAGE);
    }

    public void printResult(Result result) {
        emptyLine();
        String msg = """
            당첨 통계
            ---------
            3개 일치 (5000원)- %d개
            4개 일치 (50000원)- %d개
            5개 일치 (1500000원)- %d개
            6개 일치 (2000000000원)- %d개
            총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
            """.formatted(
            result.matchCount(3),
            result.matchCount(4),
            result.matchCount(5),
            result.matchCount(6),
            result.profitRate());

        println(msg);
    }

    private void emptyLine() {
        System.out.println();
    }

    private void println(String msg) {
        System.out.println(msg);
    }
}
