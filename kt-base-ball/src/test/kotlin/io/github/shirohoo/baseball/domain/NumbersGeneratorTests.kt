package io.github.shirohoo.baseball.domain

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow

internal class NumbersGeneratorTests {
    @RepeatedTest(10)
    fun `1부터 9까지의 중복되지 않는 랜덤한 수 세개가 생성된다`() {
        assertDoesNotThrow(NumbersGenerator::generate)
    }

    @ParameterizedTest
    @MethodSource("data")
    fun `컴퓨터의 수와 유저의 수를 비교한다`(Numbers userNumbers, MatchCounts expected) {
        Numbers computerNumbers = Numbers . from ("123");

        MatchCounts matchCounts = computerNumbers . compare (userNumbers);

        assertThat(matchCounts).isEqualTo(expected);
    }

    companion object {
        @JvmStatic
        fun Stream<Arguments> data ()
        {
            return Stream.of(
                Arguments.of(Numbers("123"), MatchCounts(0, 3)),
                Arguments.of(Numbers("124"), MatchCounts(0, 2)),
                Arguments.of(Numbers("145"), MatchCounts(0, 1)),
                Arguments.of(Numbers("135"), MatchCounts(1, 1)),
                Arguments.of(Numbers("132"), MatchCounts(2, 1)),
                Arguments.of(Numbers("345"), MatchCounts(1, 0)),
                Arguments.of(Numbers("234"), MatchCounts(2, 0)),
                Arguments.of(Numbers("789"), MatchCounts(0, 0))
            )
        }
    }
}
