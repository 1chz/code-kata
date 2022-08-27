package io.github.shirohoo;

final class AlarmExecutor extends Thread {
    private final Alarms alarms;

    public AlarmExecutor(Alarms alarms) {
        this.alarms = alarms;
    }

    @Override
    public void run() {
        while (true) {
            alarms.timeFor(Clock.currentTime())
                    .ifPresent(
                            it -> {
                                System.out.println("beep beep beep beep beep");
                            });
        }
    }
}
