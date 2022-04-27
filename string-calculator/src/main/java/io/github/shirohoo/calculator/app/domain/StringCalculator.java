package io.github.shirohoo.calculator.app.domain;

import java.util.Queue;

@SuppressWarnings("all") // will never happen
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        Queue<Double> operands = expr.getOperands();
        Queue<Character> operators = expr.getOperators();

        double result = operands.poll();

        while (operators.size() > 0) {
            ArithmeticOperator operator = ArithmeticOperator.findByOperator(operators.poll());
            result = operator.apply(result, operands.poll());
        }

        return result;
    }
}
