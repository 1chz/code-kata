package io.shirohoo.kata.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public final String name;

    private final Deck deck;

    private final List<Card> hand = new ArrayList<>();

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public void draw() {
        hand.add(deck.draw());
    }

    public int score() {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            Rank rank = card.rank();
            if (rank == Rank.ACE) {
                aceCount++;
            }
            total += rank.value;
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    @Override
    public String toString() {
        return hand + " Score: " + score();
    }
}
