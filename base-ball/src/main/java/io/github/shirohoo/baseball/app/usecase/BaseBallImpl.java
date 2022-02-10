package io.github.shirohoo.baseball.app.usecase;

import io.github.shirohoo.baseball.app.domain.DecisionResult;
import io.github.shirohoo.baseball.app.domain.Numbers;
import io.github.shirohoo.baseball.app.domain.NumbersGenerativeStrategy;
import io.github.shirohoo.baseball.app.domain.Referee;
import io.github.shirohoo.baseball.app.port.in.BaseBall;

public class BaseBallImpl implements BaseBall {
    private final Referee referee;
    private final Numbers computerNumbers;

    private BaseBallImpl(Referee referee, Numbers computerNumbers) {
        this.referee = referee;
        this.computerNumbers = computerNumbers;
    }

    public static BaseBall create(Referee referee, NumbersGenerativeStrategy strategy) {
        return new BaseBallImpl(referee, Numbers.create(strategy));
    }

    @Override
    public DecisionResult action(String input) {
        return referee.decision(computerNumbers, Numbers.nonOverlapping3digits(input));
    }
}
