package io.github.shirohoo.lotto.domain;

import static java.lang.System.lineSeparator;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public String stringValue() {
        return lottos.stream().map(Lotto::stringValue).collect(joining(lineSeparator()));
    }

    public Statistics drawn(Lotto winningLotto) {
        Collector<MatchPrize, Object, Map<MatchPrize, Long>> collector =
                collectingAndThen(groupingBy(identity(), counting()), Collections::unmodifiableMap);

        return Statistics.from(
                lottos.stream().map(lotto -> lotto.drawn(winningLotto)).collect(collector));
    }
}
