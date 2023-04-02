package io.github.shirohoo.order.application;

import io.github.shirohoo.order.domain.DefaultOrderService;
import io.github.shirohoo.order.domain.Order;
import io.github.shirohoo.order.domain.OrderService;
import io.github.shirohoo.order.domain.Product;
import io.github.shirohoo.order.domain.ProductInMemoryDao;
import io.github.shirohoo.order.domain.ProductRepository;
import io.github.shirohoo.order.domain.Products;
import io.github.shirohoo.order.domain.Receipt;
import java.util.ArrayList;
import java.util.List;

public final class ConsoleApp {
    private final ConsoleInAdapter consoleIn;
    private final ConsoleOutAdapter consoleOut;
    private final ProductRepository persistencePort;
    private final OrderService orderService;

    private ConsoleApp(String csvPath) {
        this.consoleIn = new ConsoleInAdapter();
        this.consoleOut = new ConsoleOutAdapter();
        this.persistencePort = new ProductInMemoryDao(csvPath);
        this.orderService = new DefaultOrderService(persistencePort);
    }

    public static ConsoleApp init(String csvPath) {
        return new ConsoleApp(csvPath);
    }

    public void run() {
        consoleOut.ready();
        while (consoleIn.isOrder()) {
            consoleOut.table(persistencePort.findAll());
            consoleOut.orderHistory(orders());
            consoleOut.ready();
        }
        consoleOut.exit();
    }

    private Receipt orders() {
        List<Product> products = new ArrayList<>(50);
        while (true) {
            consoleOut.id();
            String id = consoleIn.nextLine();

            consoleOut.quantity();
            String quantity = consoleIn.nextLine();

            if (id.isBlank() || quantity.isBlank()) {
                break;
            }

            try {
                Order order = Order.from(Long.parseLong(id), Integer.parseInt(quantity));
                Product take = orderService.order(order);
                products.add(take);
            } catch (Exception e) {
                consoleOut.exceptionCaught(e);
            }
        }
        return Receipt.from(Products.from(products));
    }

    public static void main(String[] args) {
        String csvPath = "items.csv";
        ConsoleApp.init(csvPath).run();
    }
}
