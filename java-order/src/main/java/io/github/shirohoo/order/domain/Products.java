package io.github.shirohoo.order.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public final class Products {
    private final Set<Product> products;

    private Products(Collection<Product> products) {
        this.products = new TreeSet<>(products);
    }

    public static Products from(Collection<Product> products) {
        return new Products(Objects.requireNonNullElse(products, Collections.emptyList()));
    }

    public Stream<Product> stream() {
        return products.stream();
    }
}
