package io.github.shirohoo;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeTests {
    @Test
    void shouldThrownFormattingException() {
        assertThrows(DateTimeParseException.class, () -> new Time("120000"));
    }

    @Test
    void shouldReturnTrue() {
        Time time = new Time("12:00:00");
        Time other = new Time("12:00:00");

        assertThat(time).isEqualTo(other);
    }
}