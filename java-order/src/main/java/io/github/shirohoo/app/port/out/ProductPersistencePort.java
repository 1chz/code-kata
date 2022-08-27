package io.github.shirohoo.app.port.out;

import io.github.shirohoo.app.domain.Order;
import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.Products;

import java.util.Optional;

public interface ProductPersistencePort {
    boolean existsById(long id);

    Optional<Product> findByOrder(Order order);

    Products findAll();

    Optional<Product> updateByOrder(Order order);
}
