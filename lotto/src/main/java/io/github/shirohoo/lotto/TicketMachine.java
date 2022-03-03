package io.github.shirohoo.lotto;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class TicketMachine {
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45)
        .boxed()
        .collect(toList());

    public Set<Integer> ticketing() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream()
            .limit(6)
            .collect(toSet());
    }
}
