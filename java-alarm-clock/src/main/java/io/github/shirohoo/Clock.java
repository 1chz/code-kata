package io.github.shirohoo;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

final class Clock extends Thread {
    private final Timer timer;

    private final int durationInMs;

    public Clock() {
        this(1_000);
    }

    private Clock(int durationInMs) {
        this.timer = new Timer();
        this.durationInMs = durationInMs;
    }

    @Override
    public void run() {
        int firstDelayInMs = 1_000;
        timer.scheduleAtFixedRate(new PrintTimeTask(), firstDelayInMs, durationInMs);
    }

    public static Time currentTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm:ss");
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
