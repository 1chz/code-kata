package io.github.shirohoo.order.domain;

import java.util.List;

public final class Product implements Comparable<Product> {
    private final long id;
    private final String name;
    private final long price;
    private final int quantity;

    private Product(long id, String name, long price, int quantity) {
        if (id < 0) {
            throw new IllegalArgumentException("id는 0보다 작을 수 없습니다. 현재 id = '%s'".formatted(id));
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "name은 null이거나 empty일 수 없습니다. 현재 name = '%s'".formatted(name));
        }
        if (price < 0) {
            throw new IllegalArgumentException(
                    "price는 0보다 작을 수 없습니다. 현재 price = '%s'".formatted(price));
        }
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "quantity는 0보다 작을 수 없습니다. 현재 quantity = '%s'".formatted(quantity));
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product from(List<String> row) {
        return new Product(
                Long.parseLong(row.get(0)),
                row.get(1),
                Long.parseLong(row.get(2)),
                Integer.parseInt(row.get(3)));
    }

    public static Product from(long id, String name, long price, int quantity) {
        return new Product(id, name, price, quantity);
    }

    public static Product of(long id, int quantity) {
        return new Product(id, "nothing", 0, quantity);
    }

    public static Product take(Order order, Product storeItem) {
        if (order.quantity() > storeItem.quantity) {
            throw new SoldOutException();
        }
        return new Product(storeItem.id(), storeItem.name(), storeItem.price(), order.quantity());
    }

    public Product decreaseQuantity(Order order) {
        return new Product(id, name, price, this.quantity - order.quantity());
    }

    @Override
    public int compareTo(Product o) {
        return Math.toIntExact(this.id - o.id);
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public long price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }
}
