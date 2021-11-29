package io.github.shirohoo.buckpal.account.application.service;

import io.github.shirohoo.buckpal.account.application.port.out.AccountLock;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(AccountId accountId) {
        // do nothing
    }

}
