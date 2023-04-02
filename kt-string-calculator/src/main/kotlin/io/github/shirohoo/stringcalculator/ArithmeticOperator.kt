package io.github.shirohoo.stringcalculator

enum class ArithmeticOperator(
    private val operator: Char,
    private val doubleBinaryOperator: (Double, Double) -> Double
) {
    PLUS('+', { left: Double, right: Double -> left + right }),
    MINUS('-', { left: Double, right: Double -> left - right }),
    MULTIPLY('*', { left: Double, right: Double -> left * right }),
    DIVIDE('/', { left: Double, right: Double -> left / right })
    ;

    fun apply(left: Double, right: Double): Double {
        if (this == DIVIDE && right == 0.0) {
            throw ArithmeticException("not divisible by zero")
        }
        return doubleBinaryOperator(left, right)
    }

    companion object {
        fun findByOperator(operator: Char): ArithmeticOperator {
            return values().first { it.operator == operator }
        }
    }
}
