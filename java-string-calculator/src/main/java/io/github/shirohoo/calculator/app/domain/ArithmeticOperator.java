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
        if (isZeroDivide(right)) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다");
        }
        return f.applyAsDouble(left, right);
    }

    private boolean isZeroDivide(double right) {
        return this == DIVIDE && right == 0;
    }
}
