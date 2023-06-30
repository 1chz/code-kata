package io.shirohoo.kata.blackjack.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CardTests {

    @Test
    void test_toString() {
        Card card = new Card(Suite.CLUBS, Rank.ACE);
        assertEquals("ACE of ♣", card.toString());
    }
}
