package io.github.shirohoo.order.domain;

import java.util.stream.Stream;

public final class Receipt {
    public static final int DELIVERY_FEE = 2_500;

    private final Products products;

    private Receipt(Products products) {
        this.products = products;
    }

    public static Receipt from(Products products) {
        return new Receipt(products);
    }

    public Stream<Product> stream() {
        return products.stream();
    }

    public long orderAmount() {
        return products.stream().mapToLong(product -> product.price() * product.quantity()).sum();
    }

    public long deliveryFee() {
        int deliveryFeeThreshold = 50_000;
        return orderAmount() < deliveryFeeThreshold ? DELIVERY_FEE : 0;
    }

    public long paymentAmount() {
        return orderAmount() + deliveryFee();
    }

    public boolean isSeparateDeliveryFee() {
        return deliveryFee() != 0;
    }
}
