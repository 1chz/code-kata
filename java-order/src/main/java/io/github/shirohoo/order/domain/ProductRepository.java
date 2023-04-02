package io.github.shirohoo.order.domain;

import java.util.Optional;

public interface ProductRepository {
    boolean existsById(long id);

    Optional<Product> findByOrder(Order order);

    Products findAll();

    Optional<Product> updateByOrder(Order order);
}
