package io.github.shirohoo.app.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTests {
    Receipt receipt;
    Receipt receiptWithDeliveryFee;

    @BeforeEach
    void setUp() {
        receipt = Receipt.from(Products.from(List.of(
            Product.from(0, "name", 1_000, 10),
            Product.from(1, "name", 1_000, 10),
            Product.from(2, "name", 1_000, 10),
            Product.from(3, "name", 1_000, 10),
            Product.from(4, "name", 1_000, 10)
        )));

        receiptWithDeliveryFee = Receipt.from(Products.from(List.of(
            Product.from(0, "name", 1_000, 10),
            Product.from(1, "name", 1_000, 10),
            Product.from(2, "name", 1_000, 10)
        )));
    }

    @Test
    void 총_주문금액을_반환한다() {
        assertAll(
            () -> assertThat(receipt.orderAmount()).isEqualTo(50_000),
            () -> assertThat(receiptWithDeliveryFee.orderAmount()).isEqualTo(30_000)
        );
    }

    @Test
    void 주문금액이_50_000원_이상이면_배송비가_무료이다() {
        assertAll(
            () -> assertThat(receipt.isSeparateDeliveryFee()).isFalse(),
            () -> assertThat(receipt.deliveryFee()).isZero(),
            () -> assertThat(receiptWithDeliveryFee.isSeparateDeliveryFee()).isTrue(),
            () -> assertThat(receiptWithDeliveryFee.deliveryFee()).isEqualTo(Receipt.DELIVERY_FEE)
        );
    }

    @Test
    void 주문금액이_50_000원_미만이면_배송비가_추가된다() {
        assertAll(
            () -> assertThat(receipt.paymentAmount()).isEqualTo(50_000),
            () -> assertThat(receiptWithDeliveryFee.paymentAmount()).isEqualTo(30_000 + Receipt.DELIVERY_FEE)
        );
    }
}