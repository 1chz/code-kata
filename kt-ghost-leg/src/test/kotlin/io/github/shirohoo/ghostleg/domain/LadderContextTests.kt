package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LadderContextTests {
    @Test
    fun `사다리의 최소 너비는 2이다`() {
        val invalidWidth = 1
        val correctHeight = 2

        assertThrows<IllegalArgumentException> { LadderContext(invalidWidth, correctHeight) }
    }

    @Test
    fun `사다리의 최소 높이는 2이다`() {
        val correctWidth = 2
        val invalidHeight = 1

        assertThrows<IllegalArgumentException> { LadderContext(correctWidth, invalidHeight) }
    }
}