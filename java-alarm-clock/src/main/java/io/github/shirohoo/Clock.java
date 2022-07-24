package io.github.shirohoo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class Clock {
    private final Timer timer;
    private final int durationInMs;

    public Clock() {
        this(1_000);
    }

    public Clock(int durationInMs) {
        this.timer = new Timer();
        this.durationInMs = durationInMs;
    }

    public void run() {
        timer.scheduleAtFixedRate(new PrintTimeTask(), new Date(), durationInMs);
    }

    public static Time currentTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = LocalTime.now().format(timeFormatter);
        return new Time(time);
    }

    private static class PrintTimeTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(Clock.currentTime());
        }
    }
}
