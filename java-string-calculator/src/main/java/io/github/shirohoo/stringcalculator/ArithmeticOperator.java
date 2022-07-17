package io.github.shirohoo.stringcalculator;

import static java.util.Arrays.stream;
import java.util.function.DoubleBinaryOperator;

public enum ArithmeticOperator {
    PLUS('+', (left, right) -> left + right),
    MINUS('-', (left, right) -> left - right),
    MULTIPLY('*', (left, right) -> left * right),
    DIVIDE('/', (left, right) -> left / right),
    ;

    private final char operator;
    private final DoubleBinaryOperator doubleBinaryOperator;

    ArithmeticOperator(char operator, DoubleBinaryOperator doubleBinaryOperator) {
        this.operator = operator;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    public static ArithmeticOperator findByOperator(char operator) {
        return stream(values())
                .filter(it -> it.operator == operator)
                .findFirst()
                .orElseThrow();
    }

    public double apply(double left, double right) {
        if (this == DIVIDE && right == 0) {
            throw new ArithmeticException("not divisible by zero");
        }
        return doubleBinaryOperator.applyAsDouble(left, right);
    }
}
