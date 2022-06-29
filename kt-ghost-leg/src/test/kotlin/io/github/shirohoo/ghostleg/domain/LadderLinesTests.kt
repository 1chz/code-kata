package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LadderLinesTests {
    @Test
    fun `사다리의 높이를 입력받아 높이만큼 사다리줄을 생성한다`() {
        // given
        val context = LadderContext(5, 5)

        // when
        val ladderLines = LadderLines(context)

        // then
        assertEquals(context.height, ladderLines.size)
    }
}