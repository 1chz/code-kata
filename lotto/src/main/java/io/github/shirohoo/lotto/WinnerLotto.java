package io.github.shirohoo.lotto;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import java.util.Set;

public final class WinnerLotto extends Lotto {
    public WinnerLotto(String s) {
        super(stream(s.split(", "))
            .map(Integer::parseInt)
            .collect(toSet()));
    }

    private WinnerLotto(Set<Integer> numbers) {
        super(numbers);
    }

    public static WinnerLotto from(String s) {
        return new WinnerLotto(s);
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
