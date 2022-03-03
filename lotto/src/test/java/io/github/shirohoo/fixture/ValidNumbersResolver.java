package io.github.shirohoo.fixture;

import io.github.shirohoo.lotto.TicketMachine;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ValidNumbersResolver implements ParameterResolver {
    private static final TicketMachine TICKET_MACHINE = new TicketMachine();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(ValidNumbers.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return TICKET_MACHINE.ticketing();
    }
}
