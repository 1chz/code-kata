package io.github.shirohoo.calculator.app.domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

public final class StringExpression {
    private static final Pattern PATTERN = Pattern.compile("^\\d+( ?[+\\-*/] ?\\d+)*$");

    private final String expr;

    public StringExpression(String expr) {
        validate(expr);
        this.expr = expr.replace(" ", "");
    }

    private void validate(String expr) {
        if (expr == null || expr.isBlank() || isNonMatchesExprPattern(expr)) {
            throw new IllegalArgumentException("올바른 수식을 입력하세요");
        }
    }

    private boolean isNonMatchesExprPattern(String expr) {
        return !PATTERN.matcher(expr).matches();
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
