package io.github.shirohoo.baseball.app.port.in;

import io.github.shirohoo.baseball.app.domain.DecisionResult;

public interface BaseBall {
    DecisionResult action(String input);
}
