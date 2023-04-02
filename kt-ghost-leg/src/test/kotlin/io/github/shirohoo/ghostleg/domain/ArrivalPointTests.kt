package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrivalPointTests {
    @Test
    fun `도착지점 이름은 비어있을 수 없다`() {
        assertThrows<IllegalArgumentException> { ArrivalPoint("") }
        assertThrows<IllegalArgumentException> { ArrivalPoint("     ") }
    }
}
