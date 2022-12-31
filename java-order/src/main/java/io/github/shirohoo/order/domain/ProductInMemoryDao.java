package io.github.shirohoo.order.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
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
import java.util.stream.Collector;

public final class ProductInMemoryDao implements ProductRepository {
    private static final Logger logger = Logger.getLogger(ProductInMemoryDao.class.getName());

    private final Map<Long, Product> store;

    public ProductInMemoryDao(String csvPath) {
        if (csvPath.isBlank()) {
            throw new IllegalArgumentException("입력이 유효하지 않습니다. 입력 csvPath = '%s'".formatted(csvPath));
        }

        Collector<Product, Object, ConcurrentHashMap<Long, Product>> collector =
                collectingAndThen(toMap(Product::id, identity()), ConcurrentHashMap::new);

        this.store = parseCsv(csvPath).stream().collect(collector);
    }

    private List<Product> parseCsv(String csvPath) {
        String absolutePath = Objects.requireNonNull(getClass().getClassLoader().getResource(csvPath))
                .getPath();

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
        return Optional.ofNullable(store.get(clusterKey));
    }

    @Override
    public Products findAll() {
        return Products.from(store.values());
    }

    @Override
    public Optional<Product> updateByOrder(Order order) {
        return findByOrder(order).map(storeItem -> {
            Product take = Product.take(order, storeItem);
            store.put(storeItem.id(), storeItem.decreaseQuantity(order));
            return take;
        });
    }
}
