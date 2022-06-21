package io.github.shirohoo.app.domain;

public final class Order {
    private final Product product;

    private Order(long id, int quantity) {
        this.product = Product.of(id, quantity);
    }

    public static Order from(long id, int quantity) {
        if (id < 0) {
            throw new IllegalArgumentException("상품번호는 음수일 수 없습니다. 현재 입력 된 상품번호 = '%d'".formatted(id));
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("주문수량은 1보다 작을 수 없습니다. 현재 입력 된 주문수량 = '%d'".formatted(quantity));
        }
        return new Order(id, quantity);
    }

    public long id() {
        return product.id();
    }

    public int quantity() {
        return product.quantity();
    }
}
