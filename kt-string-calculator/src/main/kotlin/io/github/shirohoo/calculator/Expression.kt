package io.github.shirohoo.calculator

data class Expression private constructor(val expr: String) {
    companion object {
        private val pattern: Regex = "^\\d+(?: ?[+\\-*/] ?\\d+)*$".toRegex()

        operator fun invoke(expr: String) = Expression(expr.takeIf { pattern.matches(it) } ?: throw IllegalArgumentException("올바른 수식이 아닙니다"))
    }
}
