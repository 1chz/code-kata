package io.github.shirohoo.order.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductTests {
    @Test
    void from_입력이_유효하면_인스턴스가_생성된다() {
        List<String> row = List.of("1", "name", "1000", "1");
        assertThatCode(() -> Product.from(row)).doesNotThrowAnyException();
    }

    @Test
    void of_입력이_유효하면_인스턴스가_생성된다() {
        assertThatCode(() -> Product.of(0, 1)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("invalidListForProduct")
    void from_입력이_유효하지_않으면_인스턴스가_생성되지_않는다(List<String> row) {
        assertThatThrownBy(() -> Product.from(row)).isInstanceOf(Exception.class);
    }

    public static Stream<Arguments> invalidListForProduct() {
        return Stream.of(
                arguments(List.of("-1", "name", "1000", "0")),
                arguments(List.of("0", "", "1000", "0")),
                arguments(List.of("0", "name", "-1", "0")),
                arguments(List.of("0", "name", "1000", "-1")));
    }

    @ParameterizedTest
    @MethodSource("invalidArgsForProduct")
    void of_입력이_유효하지_않으면_인스턴스가_생성되지_않는다(long id, int quantity) {
        assertThatThrownBy(() -> Product.of(id, quantity)).isInstanceOf(Exception.class);
    }

    public static Stream<Arguments> invalidArgsForProduct() {
        return Stream.of(arguments(-1, 1), arguments(1, -1));
    }

    @Test
    void 상품재고에서_주문상품을_꺼낸다() {
        // ...given
        Order order = Order.from(1, 1);
        Product storeItem = Product.of(1, 100);

        // ...when
        Product take = Product.take(order, storeItem);

        // ...then
        assertAll(
                () -> assertThat(take.id()).isEqualTo(1),
                () -> assertThat(take.quantity()).isEqualTo(1));
    }

    @Test
    void 주문수량이_상품재고보다_많으면_품절() {
        // ...given
        Order order = Order.from(1, 10);
        Product storeItem = Product.of(1, 9);

        // ...when, then
        assertThatThrownBy(() -> Product.take(order, storeItem))
                .isInstanceOf(SoldOutException.class);
    }

    @Test
    void 주문_완료된_수량을_상품재고에_업데이트한다() {
        // ...given
        Order order = Order.from(1, 10);
        Product product = Product.of(1, 10);

        // ...when
        Product decrease = product.decreaseQuantity(order);

        // ...then
        assertAll(
                () -> assertThat(decrease.id()).isEqualTo(1),
                () -> assertThat(decrease.quantity()).isEqualTo(0));
    }

    @Test
    void 비교대상보다_ID가_작다면_음수를_반환한다() {
        Product product1 = Product.of(1, 0);
        Product product2 = Product.of(2, 0);
        assertThat(product1.compareTo(product2)).isNegative();
    }

    @Test
    void 비교대상과_ID가_같다면_0을_반환한다() {
        Product product1 = Product.of(1, 0);
        Product product2 = Product.of(1, 0);
        assertThat(product1.compareTo(product2)).isEqualTo(0);
    }

    @Test
    void 비교대상보다_ID가_크다면_양수를_반환한다() {
        Product product1 = Product.of(1, 0);
        Product product2 = Product.of(1, 0);
        assertThat(product1.compareTo(product2)).isNotPositive();
    }
}
