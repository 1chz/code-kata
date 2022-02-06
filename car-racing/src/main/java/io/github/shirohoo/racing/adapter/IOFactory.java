package io.github.shirohoo.racing.adapter;

import io.github.shirohoo.racing.adapter.console.in.ConsoleInput;
import io.github.shirohoo.racing.adapter.console.out.ConsoleOutput;
import io.github.shirohoo.racing.port.in.Input;
import io.github.shirohoo.racing.port.out.Output;

public final class IOFactory {
    public static Input getInput(ApplicationType type) {
        return switch (type) {
            case CONSOLE -> new ConsoleInput();
        };
    }

    public static Output getOutput(ApplicationType type) {
        return switch (type) {
            case CONSOLE -> new ConsoleOutput();
        };
    }
}
