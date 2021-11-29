package io.github.shirohoo.buckpal.account.application.port.out;

import io.github.shirohoo.buckpal.account.application.domain.Account;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);

}
