package io.shirohoo.kata.blackjack.domain;

enum Suite {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    public final String symbol;

    Suite(String symbol) {
        this.symbol = symbol;
    }
}
