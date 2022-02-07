package io.github.shirohoo.racing.adapter.in;

import io.github.shirohoo.racing.port.in.Input;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String carNames() {
        return SCANNER.nextLine();
    }

    public int tryCount() {
        return SCANNER.nextInt();
    }
}
