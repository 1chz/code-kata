package io.github.shirohoo;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TimeTests {
    @Test
    void shouldThrownDateTimeParseException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Time("120000"),
                "입력 시간 형식이 hh:mm:ss가 아닙니다.");
    }

    @Test
    void shouldReturnEqualsTrue() {
        Time time = new Time("12:00:00");
        Time other = new Time("12:00:00");

        assertThat(time).isEqualTo(other);
    }
}
