package io.github.shirohoo.racing.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.shirohoo.racing.adapter.console.in.ConsoleInput;
import io.github.shirohoo.racing.adapter.console.out.ConsoleOutput;
import org.junit.jupiter.api.Test;

class IOFactoryTests {
    @Test
    void getInput() {
        assertThat(IOFactory.getInput(ApplicationType.CONSOLE))
            .isInstanceOf(ConsoleInput.class);
    }

    @Test
    void getOutput() {
        assertThat(IOFactory.getOutput(ApplicationType.CONSOLE))
            .isInstanceOf(ConsoleOutput.class);
    }
}
