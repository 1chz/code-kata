package io.github.shirohoo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record Time(String time) {
    public Time {
        // verify
        LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm:ss"));
    }

    @Override
    public String toString() {
        return "Time[" + time + ']';
    }
}
