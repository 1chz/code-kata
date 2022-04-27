package io.github.shirohoo.calculator.app.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class StringExpressionTests {
    @ParameterizedTest
    @ValueSource(strings = {
            "2+44-7*1/5",
            "2 + 44 - 7 * 1 / 5",
            "2 +44 -7 * 1 /5",
            "125161"
    })
    void 올바른_수식이_입력되면_인스턴스가_생성된다(String expr) {
        assertThatCode(() -> new StringExpression(expr))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "--1",
            "5++7",
            "77+1--0",
            "125161+",
            "125161-",
            "125161*",
            "125161/"
    })
    void 올바른_수식이_입력되지않으면_예외가_발생한다(String expr) {
        assertThatThrownBy(() -> new StringExpression(expr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 수식을 입력하세요");
    }

    @Test
    void 수식을_분리하여_연산자를_반환한다() {
        // given
        StringExpression expression = new StringExpression("2 +44 -7 * 1 /5");

        // when
        Queue<Character> operators = expression.getOperators();

        // then
        assertThat(operators.size()).isEqualTo(4);
    }

    @Test
    void 수식을_분리하여_피연산자를_반환한다() {
        // given
        StringExpression expression = new StringExpression("2 +44 -7 * 1 /5");

        // when
        Queue<Double> operands = expression.getOperands();

        // then
        assertThat(operands.size()).isEqualTo(5);
    }
}
