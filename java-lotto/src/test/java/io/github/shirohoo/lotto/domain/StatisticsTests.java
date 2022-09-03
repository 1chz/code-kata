package io.github.shirohoo.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class StatisticsTests {
    Statistics statistics;

    @BeforeEach
    void setUp() {
        statistics =
                Statistics.from(
                        Map.of(
                                MatchPrize.SIX, 1L,
                                MatchPrize.FIVE, 1L,
                                MatchPrize.FOUR, 1L,
                                MatchPrize.THREE, 1L));
    }

    @Test
    void shouldReturnTotalPrize() {
        long totalPrize = statistics.totalPrize();
        assertThat(totalPrize).isEqualTo(2_001_555_000L);
    }

    @Test
    void shouldReturnCountOfWinningLotto() {
        assertThat(statistics.countOfWinningLotto(MatchPrize.SIX)).isEqualTo(1);
        assertThat(statistics.countOfWinningLotto(MatchPrize.FIVE)).isEqualTo(1);
        assertThat(statistics.countOfWinningLotto(MatchPrize.FOUR)).isEqualTo(1);
        assertThat(statistics.countOfWinningLotto(MatchPrize.THREE)).isEqualTo(1);
        assertThat(statistics.countOfWinningLotto(MatchPrize.TWO)).isEqualTo(0);
        assertThat(statistics.countOfWinningLotto(MatchPrize.ONE)).isEqualTo(0);
        assertThat(statistics.countOfWinningLotto(MatchPrize.ZERO)).isEqualTo(0);
    }

    @Test
    void shouldReturnProfitRate() {
        // given
        long purchaseAmount = 2_001_555_000L;

        // when
        double profitRate = statistics.profitRate(purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(1);
    }
}
