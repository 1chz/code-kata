package io.github.shirohoo.racing.adapter;

import io.github.shirohoo.racing.adapter.console.in.ConsoleInput;
import io.github.shirohoo.racing.adapter.console.out.ConsoleOutput;
import io.github.shirohoo.racing.port.in.Input;
import io.github.shirohoo.racing.port.out.Output;
import java.util.function.Supplier;

public enum ApplicationType {
    CONSOLE(ConsoleInput::new, ConsoleOutput::new);

    private final Supplier<Input> inputSupplier;
    private final Supplier<Output> outputSupplier;

    ApplicationType(Supplier<Input> inputSupplier, Supplier<Output> outputSupplier) {
        this.inputSupplier = inputSupplier;
        this.outputSupplier = outputSupplier;
    }

    public Input getInput() {
        return inputSupplier.get();
    }

    public Output getOutput() {
        return outputSupplier.get();
    }
}
