package io.github.shirohoo.buckpal.account.application.port.out;

import io.github.shirohoo.buckpal.account.application.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);

}
