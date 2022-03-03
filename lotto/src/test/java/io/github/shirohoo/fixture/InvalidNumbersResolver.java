package io.github.shirohoo.fixture;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class InvalidNumbersResolver implements ParameterResolver {
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(46, 99)
        .boxed()
        .collect(toList());

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(InvalidNumbers.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return ticketing();
    }

    private Set<Integer> ticketing() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.stream()
            .limit(6)
            .collect(toSet());
    }
}
