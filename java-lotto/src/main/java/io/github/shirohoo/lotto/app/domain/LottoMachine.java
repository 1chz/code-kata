package io.github.shirohoo.lotto.app.domain;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.LongStream;

public class LottoMachine {
    private static final String SPLIT_REGEX = ",";

    private final RandomGenerator randomGenerator;

    public LottoMachine() {
        this.randomGenerator = RandomGeneratorFactory.getDefault().create();
    }

    public Lotto ticketing(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("winningNumbers cannot be null or empty");
        }
        return Lotto.from(
                stream(cleaning(winningNumbers))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(toSet()));
    }

    private String[] cleaning(String winningNumbers) {
        return winningNumbers.replace(" ", "").split(SPLIT_REGEX);
    }

    public Lotto ticketing() {
        return Lotto.from(randomGenerator.ints(1, 46).distinct().limit(6).boxed().collect(toSet()));
    }

    public Lottos ticketing(long purchaseOfNumber) {
        return Lottos.from(
                LongStream.rangeClosed(0, purchaseOfNumber)
                        .mapToObj(i -> this.ticketing())
                        .collect(toList()));
    }
}
