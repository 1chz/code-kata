package io.github.shirohoo.baseball.app.usecase;

import io.github.shirohoo.baseball.app.domain.Numbers;
import io.github.shirohoo.baseball.app.port.in.Try;
import io.github.shirohoo.baseball.app.port.in.TryCommand;
import io.github.shirohoo.baseball.app.port.out.TryResult;

public class UserTry implements Try {
    private final Numbers randomNumber;

    private UserTry(Numbers randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static UserTry create() {
        return new UserTry(Numbers.threeLetters());
    }

    public static UserTry from(TryCommand command) {
        return new UserTry(Numbers.from(command));
    }

    @Override
    public TryResult trys(TryCommand command) {
        return randomNumber.match(Numbers.from(command));
    }
}
