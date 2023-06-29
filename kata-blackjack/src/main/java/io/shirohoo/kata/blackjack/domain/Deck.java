package io.shirohoo.kata.blackjack.domain;

import java.util.Collections;
import java.util.Stack;

final class Deck {

    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                cards.push(new Card(suite, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }
}
