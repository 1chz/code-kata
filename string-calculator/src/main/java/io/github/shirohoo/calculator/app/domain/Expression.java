package io.github.shirohoo.calculator.app.domain;

import java.util.regex.Pattern;

public class Expression {
    private static final Pattern PATTERN = Pattern.compile("^([0-9]*)|[0-9]*(\\s[+\\-*/]\\s[0-9].*)$");

    private final String expr;

    private Expression(String expr) {
        if (expr == null || expr.isBlank() || !PATTERN.matcher(expr).matches()) {
            throw new IllegalArgumentException("Expression must be space-separated and must be valid. for example, you cannot enter a expression such as 1 + +.");
        }
        this.expr = expr;
    }

    public static Expression from(String expr) {
        return new Expression(expr);
    }

    public String[] split() {
        return expr.split(" ");
    }

    public boolean isSplit() {
        return expr.length() > 1;
    }

    public double export() {
        if (!isSplit()) {
            return Double.parseDouble(split()[0]);
        }
        throw new IllegalStateException("Current expression is not a single number");
    }
}
