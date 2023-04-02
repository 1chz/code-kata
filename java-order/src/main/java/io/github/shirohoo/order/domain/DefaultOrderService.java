package io.github.shirohoo.order.domain;

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
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Product order(Order order) throws InterruptedException, SoldOutException, IllegalArgumentException {
        // critical section
        try {
            semaphore.acquire();
            long orderId = order.id();
            if (productRepository.existsById(orderId)) {
                return productRepository.updateByOrder(order).get();
            }
            throw new IllegalArgumentException("상품번호 '%s'는 없는 항목입니다".formatted(orderId));

        } catch (Exception o_O) { // implicit upper type casting
            logger.info(o_O.getMessage());
            throw o_O;

        } finally {
            semaphore.release();
        }
    }
}
