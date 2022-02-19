package io.github.shirohoo.calculator.app.domain;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import java.util.function.DoubleBinaryOperator;

public class StringCalculator {
    private final Accumulator accumulator;
    private final Expression expression;

    private StringCalculator(Expression expression) {
        this.accumulator = new Accumulator();
        this.expression = Objects.requireNonNull(expression);
    }

    public static StringCalculator from(Expression expression) {
        return new StringCalculator(expression);
    }

    public double calculate() {
        if (!expression.isSplit()) {
            return expression.export();
        }

        accumulator.clear();
        for (String expr : expression.split()) {
            accumulator.accumulate();
            accumulator.push(expr);
        }
        accumulator.accumulate();

        return Double.parseDouble(accumulator.pop());
    }

    private static class Accumulator {
        private static final int STACK_SIZE = 3;

        private final Stack<String> accumulator;

        private Accumulator() {
            accumulator = new Stack<>();
            accumulator.setSize(STACK_SIZE);
        }

        private void clear() {
            accumulator.clear();
        }

        private boolean isFull() {
            return accumulator.size() == STACK_SIZE;
        }

        private void push(String ele) {
            if (!isFull()) {
                accumulator.push(ele);
            }
        }

        private String pop() {
            return accumulator.pop();
        }

        private void accumulate() {
            if (isFull()) {
                double right = Double.parseDouble(accumulator.pop());
                String operator = accumulator.pop();
                double left = Double.parseDouble(accumulator.pop());
                accumulator.push(ArithmeticCalculator.findBy(operator)
                    .applyAsDouble(left, right));
            }
        }
    }

    private enum ArithmeticCalculator {
        ADDITION("+", (x, y) -> x + y),
        SUBTRACTION("-", (x, y) -> x - y),
        MULTIPLICATION("*", (x, y) -> x * y),
        DIVISION("/", (x, y) -> x / y);

        private static final Map<String, ArithmeticCalculator> MAP = stream(values())
            .collect(toUnmodifiableMap(ArithmeticCalculator::operator, identity()));

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

        private String operator() {
            return operator;
        }
    }
}
