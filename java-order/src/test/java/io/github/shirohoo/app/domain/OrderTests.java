package io.github.shirohoo.app.domain;

import static io.github.shirohoo.fixture.TestDataProvider.INVALID_ID_QUANTITY_FOR_ORDER;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class OrderTests {
    @Test
    void 입력이_유효하면_인스턴스가_생성된다() {
        assertThatCode(() -> Order.from(0, 1)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource(INVALID_ID_QUANTITY_FOR_ORDER)
    void from_입력이_유효하지_않으면_인스턴스가_생성되지_않는다(long id, int quantity) {
        assertThatThrownBy(() -> Order.from(id, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
