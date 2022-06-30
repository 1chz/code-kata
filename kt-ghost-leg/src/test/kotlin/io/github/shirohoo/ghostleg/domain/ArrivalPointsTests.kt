package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrivalPointsTests {
    @Test
    fun `도착지들을 입력받아 일급컬렉션을 생성한다`() {
        // given
        val delta = ArrivalPoint("delta")
        val alpha = ArrivalPoint("alpha")
        val beta = ArrivalPoint("beta")

        // when
        val arrivalPoints = ArrivalPoints(delta, alpha, beta)

        // then
        assertEquals(3, arrivalPoints.size)
    }

    @Test
    fun `도착지의 이름들을 입력받아 일급컬렉션을 생성한다`() {
        val arrivalPoints = ArrivalPoints("delta", "alpha", "beta")

        assertEquals(3, arrivalPoints.size)
    }

    @Test
    fun `도착지는 최소한 두명 이상이어야 한다`() {
        assertThrows<IllegalArgumentException> { ArrivalPoints("delta") }
    }
}