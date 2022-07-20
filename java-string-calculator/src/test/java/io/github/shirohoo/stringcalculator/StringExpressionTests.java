package io.github.shirohoo.stringcalculator;

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
    void shouldReturnQueueForSplitExpression() {
        // given
        StringExpression sut = new StringExpression("2 +44 -7 * 1 /5");

        // when
        Queue<String> actual = sut.split();

        // then
        assertThat(actual.size()).isEqualTo(9);
    }
}
