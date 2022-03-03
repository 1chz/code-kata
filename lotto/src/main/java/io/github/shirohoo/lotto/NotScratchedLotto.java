package io.github.shirohoo.lotto;

import java.util.Objects;
import java.util.Set;

public final class NotScratchedLotto extends Lotto {
    private NotScratchedLotto(Set<Integer> numbers) {
        super(numbers);
    }

    public static NotScratchedLotto from(Set<Integer> numbers) {
        return new NotScratchedLotto(numbers);
    }

    @Override
    protected ScratchedLotto scratch(Lotto winnerLotto) {
        int matchCount = match(winnerLotto);
        return ScratchedLotto.of(matchCount, numbers);
    }

    private int match(Lotto winnerLotto) {
        Objects.requireNonNull(winnerLotto);
        return (int) numbers.stream()
            .mapToInt(number -> number)
            .filter(winnerLotto.numbers::contains)
            .count();
    }

    @Override
    protected int getMatchCount() {
        throw new IllegalStateException("Not scratched yet");
    }
}
