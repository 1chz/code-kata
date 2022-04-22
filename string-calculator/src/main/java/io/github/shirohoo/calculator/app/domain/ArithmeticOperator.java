package io.github.shirohoo.calculator.app.domain;

import java.util.function.DoubleBinaryOperator;

import static java.util.Arrays.stream;

public enum ArithmeticOperator {
    PLUS('+', (left, right) -> left + right),
    MINUS('-', (left, right) -> left - right),
    MULTIPLY('*', (left, right) -> left * right),
    DIVIDE('/', (left, right) -> left / right);

    private final char operator;
    private final DoubleBinaryOperator f;

    ArithmeticOperator(char operator, DoubleBinaryOperator f) {
        this.operator = operator;
        this.f = f;
    }

    public static ArithmeticOperator findByOperator(char operator) {
        return stream(values())
                .filter(arithmeticOperator -> arithmeticOperator.operator == operator)
                .findFirst()
                .orElseThrow();
    }

    public double apply(double left, double right) {
        return f.applyAsDouble(left, right);
    }
}
