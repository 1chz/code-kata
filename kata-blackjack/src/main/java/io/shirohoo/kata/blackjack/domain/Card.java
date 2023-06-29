package io.shirohoo.kata.blackjack.domain;

record Card(Suite suite, Rank rank) {

    @Override
    public String toString() {
        return rank + " of " + suite.symbol;
    }
}
