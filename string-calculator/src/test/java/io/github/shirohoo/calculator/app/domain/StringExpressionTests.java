package io.github.shirohoo.calculator.app.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringExpressionTests {
    @ParameterizedTest
    @ValueSource(strings = {
            "2+44-7*1/5",
            "2 + 44 - 7 * 1 / 5",
            "2 +44 -7 * 1 /5",
            "125161"
    })
    void 올바른_수식이_입력되면_인스턴스가_생성된다(String expr) {
        assertThatCode(() -> {
            StringExpression expression = new StringExpression(expr);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "--1",
            "5++7",
            "77+1--0"
    })
    void 올바른_수식이_입력되지않으면_예외가_발생한다(String expr) {
        assertThatThrownBy(() -> {
            StringExpression expression = new StringExpression(expr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 수식을 입력하세요");
    }
}
