package io.github.shirohoo.calculator

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTests {
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
        assertThrows<IllegalArgumentException>("올바른 수식이 아닙니다") {
            Expression(expr)
        }
    }
}
