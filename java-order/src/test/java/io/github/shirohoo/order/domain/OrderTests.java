package io.github.shirohoo.order.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OrderTests {
    @Test
    void 입력이_유효하면_인스턴스가_생성된다() {
        assertThatCode(() -> Order.from(0, 1)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("invalidArgsForOrder")
    void from_입력이_유효하지_않으면_인스턴스가_생성되지_않는다(long id, int quantity) {
        assertThatThrownBy(() -> Order.from(id, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> invalidArgsForOrder() {
        return Stream.of(arguments(-1, 1), arguments(0, 0), arguments(0, -1));
    }
}
