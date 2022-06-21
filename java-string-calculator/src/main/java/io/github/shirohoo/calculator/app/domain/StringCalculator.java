package io.github.shirohoo.calculator.app.domain;

import java.util.Queue;
import java.util.function.BinaryOperator;

@SuppressWarnings("all") // there will never be a problem
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        Queue<Double> operands = expr.getOperands();
        Queue<Character> operators = expr.getOperators();

        return operands.stream()
                .reduce(accumulate(operators))
                .orElseThrow();
    }

    private BinaryOperator<Double> accumulate(Queue<Character> operators) {
        return (first, last) -> {
            Character operator = operators.poll();
            ArithmeticOperator arithmeticOperator = ArithmeticOperator.findByOperator(operator);
            return arithmeticOperator.apply(first, last);
        };
    }
}
