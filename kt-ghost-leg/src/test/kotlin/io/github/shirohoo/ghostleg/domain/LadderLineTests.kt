package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LadderLineTests {
    @Test
    fun `사다리의 너비를 입력받아 너비만큼 사다리를 생성한다`() {
        // given
        val context = LadderContext(5, 5)

        // when
        val ladderLine = LadderLine(context)

        // then
        assertEquals(context.width, ladderLine.size)
    }
}
