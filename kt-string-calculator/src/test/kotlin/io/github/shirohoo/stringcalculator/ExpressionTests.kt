package io.github.shirohoo.stringcalculator

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTests {
    @Test
    fun `유효성 검사 후 인스턴스가 생성되어야 한다`() {
        val expr = Expression("125161")
        assertNotNull(expr)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2+44-7*1/5",
            "2 + 44 - 7 * 1 / 5",
            "2 +44 -7 * 1 /5",
            "125161"
        ]
    )
    fun `정상적인 수식`(expr: String) {
        assertDoesNotThrow { Expression(expr) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "",
            "+",
            "-",
            "*",
            "/",
            "--1",
            "5++7",
            "77+1--0",
            "125161+",
            "125161-",
            "125161*",
            "125161/"
        ]
    )
    fun `비정상적인 수식`(expr: String) {
        assertThrows<IllegalArgumentException>("not the correct expression") {
            Expression(expr)
        }
    }
}