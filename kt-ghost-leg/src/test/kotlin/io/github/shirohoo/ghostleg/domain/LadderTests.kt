package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LadderTests {
    @Test
    fun `사다리에는 최소 2개 이상의 사다리줄이 존재한다`() {
        val context = LadderContext(2, 2)
        val lines = LadderLines(context)

        assertDoesNotThrow { Ladder(lines) }
    }
}
