package io.github.shirohoo.racing.adapter;

import static io.github.shirohoo.racing.adapter.ApplicationType.CONSOLE;
import static org.assertj.core.api.Assertions.assertThat;
import io.github.shirohoo.racing.adapter.console.in.ConsoleInput;
import io.github.shirohoo.racing.adapter.console.out.ConsoleOutput;
import org.junit.jupiter.api.Test;

class ApplicationTypeTests {
    @Test
    void getInput() {
        assertThat(CONSOLE.getInput()).isInstanceOf(ConsoleInput.class);
    }

    @Test
    void getOutput() {
        assertThat(CONSOLE.getOutput()).isInstanceOf(ConsoleOutput.class);
    }
}