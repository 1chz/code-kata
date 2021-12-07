package io.github.shirohoo.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private final List<Card> cardDeck;

    private CardDeck() {
        this.cardDeck = new ArrayList<>();
    }

    public static CardDeck newInstance() {
        return new CardDeck();
    }

    public void add(Card card) {
        cardDeck.add(card);
    }

    public int totalScore() {
        return cardDeck.stream()
            .map(Card::getScore)
            .mapToInt(Score::intValue)
            .sum();
    }

}
