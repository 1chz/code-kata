package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LadderLineTests {
    @Test
    fun `사다리의 최소 너비는 2이다`() {
        val invalidWidth = 1

        assertThrows<IllegalArgumentException> { LadderLine(invalidWidth) }
    }

    @Test
    fun `사다리의 너비를 입력받아 너비만큼 사다리를 생성한다`() {
        // given
        val width = 5

        // when
        val ladderLine = LadderLine(width)

        // then
        assertEquals(width, ladderLine.size)
    }
}