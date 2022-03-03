package io.github.shirohoo.lotto;

import java.util.Set;

public final class ScratchedLotto extends Lotto {
    private final int matchCount;

    private ScratchedLotto(int matchCount, Set<Integer> numbers) {
        super(numbers);
        this.matchCount = matchCount;
    }

    public static ScratchedLotto of(int matchCount, Set<Integer> numbers) {
        return new ScratchedLotto(matchCount, numbers);
    }

    @Override
    protected Lotto scratch(Lotto winnerLotto) {
        throw new IllegalStateException("It's already a scratched lotto");
    }

    @Override
    protected int getMatchCount() {
        return matchCount;
    }
}
