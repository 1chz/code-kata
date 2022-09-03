package io.github.shirohoo.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.github.shirohoo.order.domain.Order;
import io.github.shirohoo.order.domain.OrderService;
import io.github.shirohoo.order.domain.Product;
import io.github.shirohoo.order.domain.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*-----------------------------------------------------------------------
target = resources/items.csv -> {
    상품번호 = 768848
    상품명 = 진공 텀블러/보틀 3종
    총수량 = 45
}
-----------------------------------------------------------------------*/
class DefaultOrderServiceTests {
    static final int PRODUCT_ID = 768_848;
    static final int PRODUCT_UNIT_QUANTITY = 5;
    static final int PRODUCT_TOTAL_QUANTITY = 45;

    OrderService port;
    ExecutorService executors;
    List<Order> successTask;
    List<Order> exceptionTask;

    @BeforeEach
    void setUp() {
        ProductRepository repository = new ProductInMemoryDao("items.csv");
        this.port = new DefaultOrderService(repository);
        this.executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.successTask =
                Stream.generate(() -> Order.from(PRODUCT_ID, PRODUCT_UNIT_QUANTITY))
                        .limit(9) // total order quantity == 45
                        .collect(Collectors.toList());

        this.exceptionTask =
                Stream.generate(() -> Order.from(PRODUCT_ID, PRODUCT_UNIT_QUANTITY))
                        .limit(10) // total order quantity == 50 | expected SoldOutException
                        .collect(Collectors.toList());
    }

    @RepeatedTest(10)
    void 상품주문_동시요청시_재고가_충분하다면_모두_성공한다() throws Exception {
        int totalQuantity =
                successTask.stream().map(orderToCompletableFuture()).toList().stream()
                        .map(CompletableFuture::join)
                        .mapToInt(Product::quantity)
                        .sum();

        assertThat(totalQuantity).isEqualTo(PRODUCT_TOTAL_QUANTITY);
    }

    @RepeatedTest(10)
    void 상품주문_동시요청시_재고가_부족하다면_품절을_알린다() throws Exception {
        assertThatThrownBy(
                        () -> {
                            int totalQuantity =
                                    exceptionTask.stream()
                                            .map(orderToCompletableFuture())
                                            .toList()
                                            .stream()
                                            .map(CompletableFuture::join)
                                            .mapToInt(Product::quantity)
                                            .sum();
                            assertThat(totalQuantity).isEqualTo(PRODUCT_TOTAL_QUANTITY);
                        })
                .isInstanceOf(Exception.class)
                .hasMessageContaining("SoldOutException 발생. 주문한 상품량이 재고량보다 큽니다");
    }

    private Function<Order, CompletableFuture<Product>> orderToCompletableFuture() {
        return order ->
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return port.order(order);
                            } catch (InterruptedException e) {
                                // do nothing
                            }
                            return Product.of(PRODUCT_ID, 0);
                        },
                        executors);
    }
}
