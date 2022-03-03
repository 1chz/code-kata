package io.github.shirohoo.fixture;

import io.github.shirohoo.lotto.LottoMachine;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ValidNumbersResolver implements ParameterResolver {
    private static final LottoMachine LOTTO_MACHINE = new LottoMachine();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(ValidNumbers.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return LOTTO_MACHINE.ticketing();
    }
}
