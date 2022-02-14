package io.github.shirohoo.calculator.domain;

import static java.util.Arrays.stream;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCalculator {
    private final Expression expression;
    private final Stack<String> accumulator;

    private StringCalculator(Expression expression) {
        this.expression = Objects.requireNonNull(expression);
        this.accumulator = new Stack<>();
    }

    public static StringCalculator from(Expression expression) {
        return new StringCalculator(expression);
    }

    public double calculate() {
        String[] split = expression.split();
        if (split.length == 1) {
            return Double.parseDouble(split[0]);
        }

        accumulator.clear();
        for (String expr : split) {
            accumulateIfEqualSize3();
            pushIfLessThanSize3(expr);
        }

        return Double.parseDouble(calculate(accumulator));
    }

    private void accumulateIfEqualSize3() {
        if (accumulator.size() == 3) {
            calculate(accumulator);
        }
    }

    private void pushIfLessThanSize3(String expr) {
        if (accumulator.size() < 3) {
            accumulator.push(expr);
        }
    }

    private String calculate(Stack<String> accumulator) {
        double right = Double.parseDouble(accumulator.pop());
        String operator = accumulator.pop();
        double left = Double.parseDouble(accumulator.pop());

        return accumulator.push(
            ArithmeticCalculator.findBy(operator)
                .applyAsDouble(left, right)
        );
    }

    private enum ArithmeticCalculator {
        ADDITION("+", (x, y) -> x + y),
        SUBTRACTION("-", (x, y) -> x - y),
        MULTIPLICATION("*", (x, y) -> x * y),
        DIVISION("/", (x, y) -> x / y);

        private static final Map<String, ArithmeticCalculator> MAP =
            stream(values()).collect(Collectors.toMap(calculator -> calculator.operator, Function.identity()));

        private final String operator;
        private final DoubleBinaryOperator function;

        ArithmeticCalculator(String operator, DoubleBinaryOperator function) {
            this.operator = operator;
            this.function = function;
        }

        private static ArithmeticCalculator findBy(String operator) {
            if (MAP.containsKey(operator)) {
                return MAP.get(operator);
            }
            throw new NoSuchElementException("'%s' is not operator or not supported operator.".formatted(operator));
        }

        private String applyAsDouble(double left, double right) {
            if (isDivideByZero(right)) {
                throw new ArithmeticException("It cannot be divided by zero.");
            }
            return String.valueOf(function.applyAsDouble(left, right));
        }

        private boolean isDivideByZero(double right) {
            return this == DIVISION && right == 0;
        }
    }
}
