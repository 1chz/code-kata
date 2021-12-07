package io.github.shirohoo.blackjack.domain;

public class Wallet {

    private Money money;

    public Wallet() {
        this.money = Money.defaultAmount();
    }

    public static Wallet newInstance() {
        return new Wallet();
    }

    public Money balance() {
        return money;
    }

    public void betting(Money betAmount) {
        this.money = money.subtract(betAmount);
    }

    public void tie(Money betAmount) {
        this.money = money.add(betAmount);
    }

    public void win(Money betAmount) {
        this.money = money.add(betAmount.multiply(2));
    }

}
