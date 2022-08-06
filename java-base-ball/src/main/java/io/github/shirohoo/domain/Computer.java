package io.github.shirohoo.domain;

public class Computer {
    private final Numbers numbers;

    public Computer(Numbers numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다");
        }
        this.numbers = numbers;
    }

    public Score compareTo(Numbers numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다");
        }

        return this.numbers.compareTo(numbers);
    }
}
