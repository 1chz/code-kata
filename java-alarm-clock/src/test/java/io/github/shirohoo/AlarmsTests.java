package io.github.shirohoo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class AlarmsTests {
    @Test
    void shouldAbleAddToTasks() {
        Alarms sut = new Alarms();
        assertDoesNotThrow(() -> sut.registry(new Time("12:00:00")));
    }

    @Test
    void shouldRemovedAlarmTask() {
        // given
        Alarms sut = new Alarms();
        sut.registry(new Time("12:00:00"));

        // when
        Optional<Time> actual = sut.timeFor(new Time("12:00:00"));

        // then
        assertTrue(actual.isPresent());
    }
}
