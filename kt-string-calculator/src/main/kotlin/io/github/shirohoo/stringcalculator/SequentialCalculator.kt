package io.github.shirohoo.stringcalculator

import java.util.LinkedList
import java.util.Queue

class SequentialCalculator : Calculator {
    override fun calculate(expr: Expression): Double {
        val operators = getOperators(expr)
        val operands = getOperands(expr)
        return operands.reduce(accumulate(operators))
    }

    private fun getOperators(expr: Expression): Queue<Char> {
        return expr.expr
            .replace("[\\d\\s]".toRegex(), "")
            .toCollection(LinkedList())
    }

    private fun getOperands(expr: Expression): Queue<Double> {
        return expr.expr
            .split("\\D".toRegex())
            .filter(String::isNotEmpty)
            .mapTo(LinkedList(), String::toDouble)
    }

    private fun accumulate(operators: Queue<Char>): (Double, Double) -> Double {
        return { accumulated: Double, nextVal: Double ->
            val operator = operators.poll()
            val arithmeticOperator = ArithmeticOperator.findByOperator(operator)
            arithmeticOperator.apply(accumulated, nextVal)
        }
    }
}