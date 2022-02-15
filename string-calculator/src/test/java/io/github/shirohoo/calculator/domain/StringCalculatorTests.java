package io.github.shirohoo.calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.github.shirohoo.calculator.app.domain.Expression;
import io.github.shirohoo.calculator.app.domain.StringCalculator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTests {
    @Test
    @DisplayName("정상적인 수식이 입력되면 초기화에 성공한다")
    void from() {
        Expression expression = Expression.from("2 + 4 - 7 * 1 / 0");

        assertThatCode(() -> {
            StringCalculator calculator = StringCalculator.from(expression);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("비정상적인 수식이 입력되면 초기화에 실패한다")
    void fromException() {
        assertThatThrownBy(() -> {
            StringCalculator calculator = StringCalculator.from(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("수식에 대한 순차적인 연산 결과를 반환한다")
    void calculate(String expr, double expected) {
        // ...given
        Expression expression = Expression.from(expr);
        StringCalculator calculator = StringCalculator.from(expression);

        // ...when
        double result = calculator.calculate();

        // ...then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> calculate() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("5 - 1", 4),
            Arguments.of("0 - 1", -1),
            Arguments.of("2 + 4 - 1 * 5 / 5", 5),
            Arguments.of("2 + 4 - 1 * 5 / 10", 2.5),
            Arguments.of("100 + 100 - 5 * 2 / 3", 130),
            Arguments.of("100 + 100 - 5 * 2 / 4", 97.5)
        );
    }

    @Test
    @DisplayName("0으로 나누려 하는 경우 예외가 발생한다")
    void calculateDividedByZero() {
        Expression expression = Expression.from("5 / 0");
        StringCalculator calculator = StringCalculator.from(expression);
        assertThatThrownBy(calculator::calculate).isInstanceOf(ArithmeticException.class);
    }
}