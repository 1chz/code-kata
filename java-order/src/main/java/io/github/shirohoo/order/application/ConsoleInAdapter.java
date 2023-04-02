package io.github.shirohoo.order.application;

import java.util.Scanner;

public final class ConsoleInAdapter {
    private final Scanner scanner;

    public ConsoleInAdapter() {
        this.scanner = new Scanner(System.in);
    }

    public boolean isOrder() {
        String line = nextLine();
        if (line.isBlank()
                || (!"o".equalsIgnoreCase(line)
                        && !"order".equalsIgnoreCase(line)
                        && !"q".equalsIgnoreCase(line)
                        && !"quit".equalsIgnoreCase(line))) {
            throw new IllegalArgumentException("'o[order]' 또는 'q[quit]' 를 입력해야 합니다.");
        }
        return "o".equalsIgnoreCase(line) || "order".equalsIgnoreCase(line);
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
