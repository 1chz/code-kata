package io.github.shirohoo.bowling;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingTest {

    private Bowling bowling;

    @BeforeEach
    void setUp() {
        bowling = new Bowling();
    }

    @Test
    void canRoll() throws Exception {
        bowling.roll(0);
    }

    @Test
    void allGutter() throws Exception {
        rollMany(0, 20);
        assertThat(bowling.getScore()).isEqualTo(0);
    }

    @Test
    void allOne() throws Exception {
        rollMany(1, 20);
        assertThat(bowling.getScore()).isEqualTo(20);
    }

    @Test
    void oneSpare() throws Exception {
        spare();
        bowling.roll(3);
        rollMany(17, 0);
        assertThat(bowling.getScore()).isEqualTo(16);
    }

    @Test
    void oneStrike() throws Exception {
        strike();
        bowling.roll(5);
        bowling.roll(3);
        rollMany(16, 0);
        assertThat(bowling.getScore()).isEqualTo(26);
    }

    @Test
    void perfectGame() throws Exception {
        perfect();
        assertThat(bowling.getScore()).isEqualTo(300);
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            bowling.roll(pins);
        }
    }

    private void spare() {
        bowling.roll(5);
        bowling.roll(5);
    }

    private void strike() {
        bowling.roll(10);
    }

    private void perfect() {
        rollMany(10, 10);
        strike();
        strike();
    }

}