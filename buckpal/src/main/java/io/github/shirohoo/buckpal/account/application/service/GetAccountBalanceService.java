package io.github.shirohoo.buckpal.account.application.service;

import io.github.shirohoo.buckpal.account.application.port.in.GetAccountBalanceQuery;
import io.github.shirohoo.buckpal.account.application.port.out.LoadAccountPort;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import io.github.shirohoo.buckpal.account.application.domain.Money;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
            .calculateBalance();
    }

}
