package io.github.shirohoo.stringcalculator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.BinaryOperator;

@SuppressWarnings("all") // there will never be a problem
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        return calculate(expr.splitExpression());
//
//        Queue<Double> operands = expr.getOperands();
//        Queue<Character> operators = expr.getOperators();
//
//        return operands.stream()
//                .reduce(accumulate(operators))
//                .orElseThrow();
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

    private BinaryOperator<Double> accumulate(Queue<Character> operators) {
        return (first, last) -> {
            Character operator = operators.poll();
            ArithmeticOperator arithmeticOperator = ArithmeticOperator.findByOperator(operator);
            return arithmeticOperator.apply(first, last);
        };
    }
}
