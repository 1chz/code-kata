package io.github.shirohoo.baseball.domain

import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow

internal class RandomNumbersGeneratorTests {
    @RepeatedTest(10)
    fun `1부터 9까지의 중복되지 않는 랜덤한 수 세개가 생성된다`() {
        assertDoesNotThrow(RandomNumbersGenerator::generate)
    }
}
