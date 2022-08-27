package io.github.shirohoo.app.port.in;

import io.github.shirohoo.app.domain.Order;
import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.SoldOutException;

public interface OrderPort {
    Product order(Order order)
            throws InterruptedException, SoldOutException, IllegalArgumentException;
}
