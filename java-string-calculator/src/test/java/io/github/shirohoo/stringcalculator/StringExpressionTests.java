package io.github.shirohoo.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringExpressionTests {
    @ParameterizedTest
    @ValueSource(strings = {
            "2+44-7*1/5",
            "2 + 44 - 7 * 1 / 5",
            "2 +44 -7 * 1 /5",
            "125161"
    })
    void shouldInstanceIsCreatedWhenCorrectExpressionEntered(String expr) {
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
    void shouldNotEnteredAnExceptionIsRaised(String expr) {
        assertThatThrownBy(() -> new StringExpression(expr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Please enter the correct expression.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123 +1 /0",
            "123 +1 /0 +3",
            "123 +1 /0*2",
    })
    void shouldThrowExceptionThatSaysNotDivisibleByZero(String expr) {
        assertThatThrownBy(() -> new StringExpression(expr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can't divide by zero because it causes an infinite loop.");
    }

    @Test
    void shouldSplitExpressionReturnOperator() {
        // given
        StringExpression sut = new StringExpression("2 +44 -7 * 1 /5");

        // when
        Queue<Character> actual = sut.getOperators();

        // then
        assertThat(actual.size()).isEqualTo(4);
    }

    @Test
    void shouldSplitExpressionReturnOperand() {
        // given
        StringExpression sut = new StringExpression("2 +44 -7 * 1 /5");

        // when
        Queue<Double> actual = sut.getOperands();

        // then
        assertThat(actual.size()).isEqualTo(5);
    }
}
