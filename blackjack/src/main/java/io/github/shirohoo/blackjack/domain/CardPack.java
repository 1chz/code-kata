package io.github.shirohoo.blackjack.domain;

import io.github.shirohoo.blackjack.domain.Card.Classes;
import io.github.shirohoo.blackjack.domain.Card.Pattern;
import java.util.Collections;
import java.util.Stack;

public class CardPack {

    public static final int CARD_PACK_SIZE = 52;

    private final Stack<Card> cardPack;

    private CardPack(Stack<Card> cardPack) {
        this.cardPack = cardPack;
        Collections.shuffle(cardPack);
    }

    public static CardPack newCardPack() {
        Stack<Card> cardPack = new Stack<>();

        for (Pattern pattern : Pattern.values()) {
            for (Classes classes : Classes.values()) {
                cardPack.push(Card.of(pattern, classes));
            }
        }

        if (cardPack.size() != CARD_PACK_SIZE) {
            throw new IllegalStateException("card pack size must be " + CARD_PACK_SIZE + ".");
        }

        return new CardPack(cardPack);
    }

    public Card draw() {
        if (cardPack.empty()) {
            throw new IllegalStateException("The card pack is empty.");
        }
        return cardPack.pop();
    }

}
