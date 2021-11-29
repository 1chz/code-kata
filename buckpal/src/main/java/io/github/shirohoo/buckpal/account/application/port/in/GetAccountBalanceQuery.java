package io.github.shirohoo.buckpal.account.application.port.in;

import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import io.github.shirohoo.buckpal.account.application.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);

}
