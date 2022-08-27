package io.github.shirohoo.app;

import io.github.shirohoo.adapter.in.console.ConsoleInAdapter;
import io.github.shirohoo.adapter.out.console.ConsoleOutAdapter;
import io.github.shirohoo.adapter.out.inmemory.ProductInMemoryPersistenceAdapter;
import io.github.shirohoo.app.domain.Order;
import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.Products;
import io.github.shirohoo.app.domain.Receipt;
import io.github.shirohoo.app.port.in.OrderPort;
import io.github.shirohoo.app.port.in.OrderUseCase;
import io.github.shirohoo.app.port.out.ProductPersistencePort;

import java.util.ArrayList;
import java.util.List;

public final class ConsoleApp {
    private final ConsoleInAdapter consoleIn;
    private final ConsoleOutAdapter consoleOut;
    private final ProductPersistencePort persistencePort;
    private final OrderPort orderPort;

    private ConsoleApp(String csvPath) {
        this.consoleIn = new ConsoleInAdapter();
        this.consoleOut = new ConsoleOutAdapter();
        this.persistencePort = new ProductInMemoryPersistenceAdapter(csvPath);
        this.orderPort = new OrderUseCase(persistencePort);
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
                Product take = orderPort.order(order);
                products.add(take);
            } catch (Exception e) {
                consoleOut.exceptionCaught(e);
            }
        }
        return Receipt.from(Products.from(products));
    }
}
