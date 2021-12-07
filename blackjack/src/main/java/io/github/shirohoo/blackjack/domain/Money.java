package io.github.shirohoo.blackjack.domain;

import lombok.Value;

@Value
public class Money {

    Long amount;

    private Money(Long amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money((long) amount);
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public static Money defaultAmount() {
        return Money.of(10_000);
    }

    public long longValue() {
        return amount;
    }

    public Money add(Money money) {
        return Money.of(this.amount + money.longValue());
    }

    public Money subtract(Money money) {
        return Money.of(this.amount - money.longValue());
    }

    public Money multiply(int multiplicand) {
        return Money.of(this.amount * multiplicand);
    }

    @Override
    public String toString() {
        return amount.toString();
    }

}
