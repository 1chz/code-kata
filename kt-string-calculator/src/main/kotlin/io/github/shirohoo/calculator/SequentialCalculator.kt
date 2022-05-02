package io.github.shirohoo.calculator

import java.util.*

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
            .split("")
            .filter(String::isNotEmpty)
            .map(String::single)
            .toCollection(LinkedList())
    }

    private fun getOperands(expr: Expression): Queue<Double> {
        return expr.expr
            .split("\\D".toRegex())
            .filter(String::isNotEmpty)
            .map(String::toDouble)
            .toCollection(LinkedList())
    }
}
