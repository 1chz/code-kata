package io.github.shirohoo;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

final class Alarms {
    private final Set<Time> times;

    public Alarms() {
        this(new CopyOnWriteArraySet<>());
    }

    public Alarms(Set<Time> times) {
        this.times = times;
    }

    public void registry(Time time) {
        //        try {
        times.add(time);
        //        } catch (Exception e) {
        //            System.out.println(e.getMessage());
        // do nothing...
        //        }

        System.out.println("Current alarms = " + times);
    }

    public Optional<Time> timeFor(Time time) {
        return times.removeIf(time::equals) ? Optional.of(time) : Optional.empty();
    }
}
