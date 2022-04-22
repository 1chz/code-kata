package io.github.shirohoo.calculator.app.domain;

import java.util.regex.Pattern;

public final class StringExpression {
    private static final Pattern EXPR_PATTERN = Pattern.compile("^\\d+|\\d?\\s?[+\\-*/]\\s?\\d.*$");

    private final String expr;

    public StringExpression(String expr) {
        if (expr == null || expr.isBlank() || isNonMatchesExprPattern(expr)) {
            throw new IllegalArgumentException("올바른 수식을 입력하세요");
        }
        this.expr = expr;
    }

    private boolean isNonMatchesExprPattern(String expr) {
        return !EXPR_PATTERN.matcher(expr).matches();
    }
}
