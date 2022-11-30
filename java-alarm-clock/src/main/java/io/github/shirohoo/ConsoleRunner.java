package io.github.shirohoo;


import java.util.Scanner;

public class ConsoleRunner {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Alarms alarms = new Alarms();
        AlarmExecutor executor = new AlarmExecutor(alarms);
        Clock clock = new Clock();

        clock.start();
        executor.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Time time = new Time(sc.nextLine());
                alarms.registry(time);
                System.out.println(time + " registered an alarm.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // do nothing ...
            }
        }
    }
}
