package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class NameTests {
    @Test
    fun `이름은 영어, 한글, 숫자로 이뤄질 수 있다`() {
        assertDoesNotThrow { Name("철수") }
        assertDoesNotThrow { Name("james") }
        assertDoesNotThrow { Name("1") }
    }

    @Test
    fun `이름은 비어있을 수 없다`() {
        assertThrows<IllegalArgumentException> { Name("") }
        assertThrows<IllegalArgumentException> { Name("     ") }
    }

    @Test
    fun `이름의 길이는 5글자 이하여야 한다`() {
        assertThrows<IllegalArgumentException> { Name("abcdef") }
    }
}
