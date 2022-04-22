package io.github.shirohoo.calculator.app.domain;

import java.util.Deque;
import java.util.Queue;

@SuppressWarnings("all") // will never happen
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        Deque<Double> operands = expr.getOperands();
        Queue<Character> operators = expr.getOperators();

        while (operators.size() > 0) {
            ArithmeticOperator operator = ArithmeticOperator.findByOperator(operators.poll());
            double left = operands.pollFirst();
            double right = operands.pollFirst();

            double calculationResult = operator.apply(left, right);
            operands.offerFirst(calculationResult);
        }

        return operands.poll();
    }
}
