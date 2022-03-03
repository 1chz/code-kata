package io.github.shirohoo.lotto;

import java.util.Set;

public abstract class Lotto {
    public final static int LOTTO_PRICE = 1_000;

    protected final Set<Integer> numbers;

    protected Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        int reduced = numbers.stream()
            .reduce(0, Integer::sum);
        if (reduced < 21 || reduced > 255) {
            throw new IllegalArgumentException();
        }
    }

    protected abstract Lotto scratch(Lotto winnerLotto);

    protected abstract int getMatchCount();
}
