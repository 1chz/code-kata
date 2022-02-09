package io.github.shirohoo.baseball.app.port.in;

import io.github.shirohoo.baseball.app.port.out.TryResult;

public interface Try {
    TryResult action(TryCommand command);
}
