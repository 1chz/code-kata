package io.github.shirohoo.buckpal.account.application.port.out;

import io.github.shirohoo.buckpal.account.application.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);

}
