package io.github.shirohoo.lotto;

import java.util.Set;

public final class WinnerLotto extends Lotto {
    private WinnerLotto(Set<Integer> numbers) {
        super(numbers);
    }

    public static WinnerLotto from(Set<Integer> numbers) {
        return new WinnerLotto(numbers);
    }

    @Override
    protected Lotto scratch(Lotto winnerLotto) {
        throw new IllegalStateException("It's already a scratched lotto");
    }

    @Override
    protected int getMatchCount() {
        return 6;
    }
}
