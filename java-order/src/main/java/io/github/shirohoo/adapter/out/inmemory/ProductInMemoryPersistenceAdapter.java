package io.github.shirohoo.adapter.out.inmemory;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.github.shirohoo.app.domain.Order;
import io.github.shirohoo.app.domain.Product;
import io.github.shirohoo.app.domain.Products;
import io.github.shirohoo.app.port.out.ProductPersistencePort;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public final class ProductInMemoryPersistenceAdapter implements ProductPersistencePort {
    private static final Logger logger =
            Logger.getLogger(ProductInMemoryPersistenceAdapter.class.getName());

    private final Map<Long, Product> store;

    public ProductInMemoryPersistenceAdapter(String csvPath) {
        if (csvPath.isBlank()) {
            throw new IllegalArgumentException(
                    "입력이 유효하지 않습니다. 입력 csvPath = '%s'".formatted(csvPath));
        }
        this.store =
                parseCsv(csvPath).stream()
                        .collect(
                                collectingAndThen(
                                        toMap(Product::id, identity()), ConcurrentHashMap::new));
    }

    private List<Product> parseCsv(String csvPath) {
        String absolutePath =
                Objects.requireNonNull(getClass().getClassLoader().getResource(csvPath)).getPath();

        List<List<String>> records = new ArrayList<>(30);
        try (CSVReader csvReader = new CSVReader(new FileReader(absolutePath))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }

            // remove table headers
            records.remove(0);

            return records.stream().map(Product::from).toList();
        } catch (CsvValidationException | IOException e) {
            logger.info(e.getMessage());

            // shutdown gracefully
            System.exit(0);

            // code lines that will never be executed
            return Collections.emptyList();
        }
    }

    @Override
    public boolean existsById(long id) {
        return store.containsKey(id);
    }

    @Override
    public Optional<Product> findByOrder(Order order) {
        long clusterKey = order.id();
        return store.containsKey(clusterKey)
                ? Optional.of(store.get(clusterKey))
                : Optional.empty();
    }

    @Override
    public Products findAll() {
        return Products.from(store.values());
    }

    @Override
    public Optional<Product> updateByOrder(Order order) {
        return findByOrder(order)
                .map(
                        storeItem -> {
                            Product take = Product.take(order, storeItem);
                            store.put(storeItem.id(), storeItem.decreaseQuantity(order));
                            return take;
                        });
    }
}
