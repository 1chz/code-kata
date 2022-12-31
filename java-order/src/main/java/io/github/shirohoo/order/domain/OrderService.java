package io.github.shirohoo.order.domain;

public interface OrderService {
    Product order(Order order) throws InterruptedException, SoldOutException, IllegalArgumentException;
}
