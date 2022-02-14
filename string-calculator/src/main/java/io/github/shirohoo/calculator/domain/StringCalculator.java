package io.github.shirohoo.calculator.domain;

import java.util.Objects;

public class StringCalculator {
    private final Expression expression;

    private StringCalculator(Expression expression) {
        this.expression = Objects.requireNonNull(expression);
    }

    public static StringCalculator from(Expression expression) {
        return new StringCalculator(expression);
    }
}
