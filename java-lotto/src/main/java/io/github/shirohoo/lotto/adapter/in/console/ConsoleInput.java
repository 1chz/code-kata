package io.github.shirohoo.lotto.adapter.in.console;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner sc;

    public ConsoleInput() {
        this.sc = new Scanner(System.in);
    }

    public long enterPurchaseAmount() {
        long purchaseAmount = sc.nextLong();
        sc.nextLine(); // buffer cleaning
        return purchaseAmount;
    }

    public String enterWinningNumbers() {
        return sc.nextLine();
    }
}
