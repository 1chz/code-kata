package io.github.shirohoo.stringcalculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

public final class StringExpression {
    private static final Pattern pattern = Pattern.compile("^\\d+(:? ?[+\\-*/] ?\\d+)*$");

    private final String expr;

    public StringExpression(String expr) {
        if (expr == null || !pattern.matcher(expr).matches()) {
            throw new IllegalArgumentException("Please enter the correct expression.");
        }

        expr = expr.replace(" ", "");

        if (expr.contains("/0")) {
            throw new IllegalArgumentException("You can't divide by zero because it causes an infinite loop.");
        }

        this.expr = expr;
    }

    public Queue<Character> getOperators() {
        String[] split = expr.replaceAll("\\d", "").split("");

        if (split.length == 0 || split.length == 1) {
            return new LinkedList<>();
        }

        return stream(split)
                .map(operator -> operator.charAt(0))
                .collect(toCollection(LinkedList::new));
    }

    public Queue<Double> getOperands() {
        return stream(expr.split("\\D"))
                .map(Double::parseDouble)
                .collect(toCollection(LinkedList::new));
    }
}
