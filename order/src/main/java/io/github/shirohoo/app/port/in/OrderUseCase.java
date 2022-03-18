package io.github.shirohoo.app.port.in;

import io.github.shirohoo.app.domain.Order;
import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.SoldOutException;
import io.github.shirohoo.app.port.out.ProductPersistencePort;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public final class OrderUseCase implements OrderPort {
    private static final Logger logger = Logger.getLogger(OrderUseCase.class.getName());

    private final Semaphore semaphore;
    private final ProductPersistencePort productPersistencePort;

    public OrderUseCase(ProductPersistencePort productPersistencePort) {
        this.semaphore = new Semaphore(1); // binary semaphore
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public Product order(Order order) throws InterruptedException, SoldOutException, IllegalArgumentException {
        // critical section
        try {
            semaphore.acquire();
            if (productPersistencePort.existsById(order.id())) {
                return productPersistencePort.updateByOrder(order)
                    .orElseThrow(() -> notFound(order));
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
