package io.github.shirohoo;

import io.github.shirohoo.app.ConsoleApp;

public class Bootstrapper {
    public static void main(String[] args) {
        String csvPath = "items.csv";
        ConsoleApp.init(csvPath).run();
    }
}
