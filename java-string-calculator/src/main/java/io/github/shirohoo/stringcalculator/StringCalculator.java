package io.github.shirohoo.stringcalculator;

import java.util.ArrayDeque;

@SuppressWarnings("all") // there will never be a problem
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        return calculate(expr.split());
    }

    private double calculate(ArrayDeque<String> queue) {
        if (queue.size() == 1) {
            return Double.parseDouble(queue.removeFirst());
        }

        double left = Double.parseDouble(queue.removeFirst());
        ArithmeticOperator operator = ArithmeticOperator.findByOperator(queue.removeFirst().charAt(0));
        double right = Double.parseDouble(queue.removeFirst());
        double result = operator.apply(left, right);

        queue.addFirst(String.valueOf(result));

        return calculate(queue);
    }
}
