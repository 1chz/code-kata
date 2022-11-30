package io.github.shirohoo;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

record Time(String time) {
    public Time {
        try {
            LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm:ss"));
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 시간 형식이 hh:mm:ss가 아닙니다.");
        }
    }

    @Override
    public String toString() {
        return "Time[" + time + ']';
    }
}
