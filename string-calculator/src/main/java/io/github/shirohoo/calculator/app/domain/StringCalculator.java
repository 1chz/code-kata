package io.github.shirohoo.calculator.app.domain;

import static io.github.shirohoo.calculator.app.domain.ArithmeticOperator.findByOperator;
import java.util.Queue;

@SuppressWarnings("all") // will never happen
public final class StringCalculator {
    public double calculate(StringExpression expr) {
        Queue<Double> operands = expr.getOperands();
        Queue<Character> operators = expr.getOperators();

        return operands.stream()
            .reduce((left, right) -> findByOperator(operators.poll()).apply(left, right))
            .orElseThrow();
    }
}
