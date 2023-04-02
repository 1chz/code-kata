package io.github.shirohoo.domain;

public class Computer {
    private final Numbers numbers;

    public Computer(Numbers numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("input cannot be null");
        }
        this.numbers = numbers;
    }

    public Score compareTo(Numbers numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("input cannot be null");
        }

        return this.numbers.compareTo(numbers);
    }
}
