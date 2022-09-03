package io.github.shirohoo.order.application;

import io.github.shirohoo.order.domain.Order;
import io.github.shirohoo.order.domain.OrderService;
import io.github.shirohoo.order.domain.Product;
import io.github.shirohoo.order.domain.ProductRepository;
import io.github.shirohoo.order.domain.SoldOutException;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public final class DefaultOrderService implements OrderService {
    private static final Logger logger = Logger.getLogger(DefaultOrderService.class.getName());

    private final Semaphore semaphore;
    private final ProductRepository productRepository;

    public DefaultOrderService(ProductRepository productRepository) {
        this.semaphore = new Semaphore(1); // binary semaphore
        this.productRepository = productRepository;
    }

    @Override
    public Product order(Order order)
            throws InterruptedException, SoldOutException, IllegalArgumentException {
        // critical section
        try {
            semaphore.acquire();
            if (productRepository.existsById(order.id())) {
                return productRepository.updateByOrder(order).orElseThrow(() -> notFound(order));
            }
            throw notFound(order);

        } catch (Exception o_O) { // implicit upper type casting
            logger.info(o_O.getMessage());
            throw o_O;

        } finally {
            semaphore.release();
        }
    }

    private IllegalArgumentException notFound(Order order) {
        return new IllegalArgumentException("상품번호 '%s'는 없는 항목입니다".formatted(order.id()));
    }
}
