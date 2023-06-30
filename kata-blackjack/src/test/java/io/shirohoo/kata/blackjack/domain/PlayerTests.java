package io.shirohoo.kata.blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PlayerTests {

    @Test
    void test_draw_and_score() {
        Player james = new Player("james", new Deck());
        assertEquals(0, james.score());

        james.draw();
        assertThat(james.score()).isBetween(1, 11);
    }

    @Test
    void test_toString() {
        Player james = new Player("james", new Deck());

        james.draw();
        assertThat(james.toString()).contains(" Score: ");
    }
}
