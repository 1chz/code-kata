package io.github.shirohoo.baseball.adapter.in.console;

import io.github.shirohoo.baseball.app.port.in.TryCommand;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public TryCommand trys() {
        return TryCommand.from(scanner.nextLine());
    }

    public boolean restartIntentions() {
        int intentions = scanner.nextInt();
        if (intentions == 1) {
            return true;
        }
        if (intentions == 2) {
            return false;
        }
        throw new IllegalArgumentException(String.format("'%s' is unknown input.", intentions));
    }
}
