package io.github.shirohoo.order.domain;

public final class SoldOutException extends RuntimeException {
    private static final String MESSAGE = "SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다.";

    public SoldOutException() {
        super(MESSAGE);
    }
}
