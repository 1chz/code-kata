package io.github.shirohoo.stringcalculator;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public final class StringExpression {
    private static final Pattern PATTERN = Pattern.compile("^\\d+(:? ?[+\\-*/] ?\\d+)*$");

    private final String expr;

    public StringExpression(String expr) {
        if (expr == null || !PATTERN.matcher(expr).matches()) {
            throw new IllegalArgumentException("Please enter the correct expression.");
        }
        this.expr = expr.replace(" ", "");
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
