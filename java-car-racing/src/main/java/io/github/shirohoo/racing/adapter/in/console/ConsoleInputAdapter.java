package io.github.shirohoo.racing.adapter.in.console;

import java.util.Scanner;

public class ConsoleInputAdapter {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String carNames() {
        return SCANNER.nextLine();
    }

    public int tryCount() {
        return SCANNER.nextInt();
    }
}
