package io.github.shirohoo.calculator

import java.util.*
import java.util.function.DoubleBinaryOperator

class SequentialCalculator : Calculator {
    override fun calculate(expr: Expression): Double {
        val operators = getOperators(expr)
        val operands = getOperands(expr)

        var result = operands.poll()
        while (operators.isNotEmpty()) {
            ArithmeticOperator.findByOperator(operators.poll()).apply {
                result = apply(result, operands.poll())
            }
        }
        return result
    }

    private fun getOperators(expr: Expression): Queue<Char> {
        return expr.expr
            .replace("[\\d\\s]".toRegex(), "")
            .splitToSequence("")
            .filter(String::isNotEmpty)
            .map(String::single)
            .toCollection(LinkedList())
    }

    private fun getOperands(expr: Expression): Queue<Double> {
        return expr.expr
            .splitToSequence("\\D".toRegex())
            .filter(String::isNotEmpty)
            .map(String::toDouble)
            .toCollection(LinkedList())
    }

    private enum class ArithmeticOperator(private val operator: Char, private val f: DoubleBinaryOperator) {
        PLUS('+', DoubleBinaryOperator { left: Double, right: Double -> left + right }),
        MINUS('-', DoubleBinaryOperator { left: Double, right: Double -> left - right }),
        MULTIPLY('*', DoubleBinaryOperator { left: Double, right: Double -> left * right }),
        DIVIDE('/', DoubleBinaryOperator { left: Double, right: Double -> left / right });

        fun apply(left: Double, right: Double): Double {
            if (isZeroDivide(right)) {
                throw ArithmeticException("0으로는 나눌 수 없습니다")
            }
            return f.applyAsDouble(left, right)
        }

        private fun isZeroDivide(right: Double): Boolean {
            return this == DIVIDE && right == 0.0
        }

        companion object {
            fun findByOperator(operator: Char): ArithmeticOperator {
                return values()
                    .asSequence()
                    .filter { it.operator == operator }
                    .first()
            }
        }
    }
}
