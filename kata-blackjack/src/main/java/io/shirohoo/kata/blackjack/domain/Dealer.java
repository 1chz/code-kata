package io.shirohoo.kata.blackjack.domain;

public final class Dealer extends Player {

    public Dealer(Deck deck) {
        super("Dealer", deck);
    }

    public boolean shouldDraw() {
        return score() <= 16;
    }
}
