package io.github.shirohoo.fixture;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public final class TestDataProvider {
    private static final String PATH = "io.github.shirohoo.fixture.TestDataProvider#";

    public static final String INVALID_LIST_FOR_PRODUCT = PATH + "invalidListForProduct";
    public static final String INVALID_ID_QUANTITY_FOR_PRODUCT = PATH + "invalidArgsForProduct";
    public static final String INVALID_ID_QUANTITY_FOR_ORDER = PATH + "invalidArgsForOrder";

    public static Stream<Arguments> invalidListForProduct() {
        return Stream.of(
                arguments(List.of("-1", "name", "1000", "0")),
                arguments(List.of("0", "", "1000", "0")),
                arguments(List.of("0", "name", "-1", "0")),
                arguments(List.of("0", "name", "1000", "-1")));
    }

    public static Stream<Arguments> invalidArgsForProduct() {
        return Stream.of(arguments(-1, 1), arguments(1, -1));
    }

    public static Stream<Arguments> invalidArgsForOrder() {
        return Stream.of(arguments(-1, 1), arguments(0, 0), arguments(0, -1));
    }
}
