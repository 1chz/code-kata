package io.github.shirohoo.lotto;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45)
        .boxed()
        .collect(toList());

    public Set<Integer> ticketing() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream()
            .limit(6)
            .sorted()
            .collect(toCollection(LinkedHashSet::new));
    }
}
