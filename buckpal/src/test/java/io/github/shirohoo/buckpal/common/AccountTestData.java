package io.github.shirohoo.buckpal.common;

import io.github.shirohoo.buckpal.account.application.domain.Account;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import io.github.shirohoo.buckpal.account.application.domain.ActivityWindow;
import io.github.shirohoo.buckpal.account.application.domain.Money;

public class AccountTestData {

    public static AccountBuilder defaultAccount() {
        return new AccountBuilder()
            .withAccountId(new AccountId(42L))
            .withBaselineBalance(Money.of(999L))
            .withActivityWindow(new ActivityWindow(
                ActivityTestData.defaultActivity().build(),
                ActivityTestData.defaultActivity().build()));
    }


    public static class AccountBuilder {

        private AccountId accountId;
        private Money baselineBalance;
        private ActivityWindow activityWindow;

        public AccountBuilder withAccountId(AccountId accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder withBaselineBalance(Money baselineBalance) {
            this.baselineBalance = baselineBalance;
            return this;
        }

        public AccountBuilder withActivityWindow(ActivityWindow activityWindow) {
            this.activityWindow = activityWindow;
            return this;
        }

        public Account build() {
            return Account.withId(this.accountId, this.baselineBalance, this.activityWindow);
        }

    }


}
