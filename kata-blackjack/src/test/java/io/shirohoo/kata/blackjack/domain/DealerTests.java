package io.shirohoo.kata.blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DealerTests {
    @Test
    void test_should_draw() {
        Dealer dealer = new Dealer(new Deck());

        dealer.draw();

        assertThat(dealer.shouldDraw()).isTrue();
    }
}
