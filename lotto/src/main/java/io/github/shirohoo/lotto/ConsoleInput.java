package io.github.shirohoo.lotto;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int enterPurchaseAmount() {
        return scanner.nextInt();
    }

    public String enterWinningNumbers() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
