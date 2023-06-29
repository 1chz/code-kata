package io.shirohoo.kata.blackjack.domain;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public abstract class BlackJack {

    protected final Dealer dealer;

    protected final List<Player> players;

    public BlackJack(String[] names) {
        Deck deck = new Deck();

        this.dealer = new Dealer(deck);
        this.players = stream(names).distinct().map(it -> new Player(it, deck)).collect(toList());

        Collections.shuffle(players);
    }

    public abstract void start();
}
