package io.github.shirohoo.stringcalculator;

import java.util.ArrayDeque;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

public final class StringExpression {
    private final String expr;

    public StringExpression(String expr) {
        if (expr == null || !expr.matches("^\\d+(:? ?[+\\-*/] ?\\d+)*$")) {
            throw new IllegalArgumentException("Please enter the correct expression.");
        }

        expr = expr.replace(" ", "");
        if (expr.contains("/0")) {
            throw new IllegalArgumentException("You can't divide by zero because it causes an infinite loop.");
        }

        this.expr = expr;
    }

    public ArrayDeque<String> split() {
        return stream(expr.replaceAll("(\\d)([+\\-*/])", "$1 $2 ")
                .split(" "))
                .collect(toCollection(ArrayDeque::new));
    }
}
