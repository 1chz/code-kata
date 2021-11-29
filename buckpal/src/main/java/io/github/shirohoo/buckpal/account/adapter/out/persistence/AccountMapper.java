package io.github.shirohoo.buckpal.account.adapter.out.persistence;

import io.github.shirohoo.buckpal.account.application.domain.Account;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import io.github.shirohoo.buckpal.account.application.domain.Activity;
import io.github.shirohoo.buckpal.account.application.domain.Activity.ActivityId;
import io.github.shirohoo.buckpal.account.application.domain.ActivityWindow;
import io.github.shirohoo.buckpal.account.application.domain.Money;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
class AccountMapper {

    Account mapToDomainEntity(AccountJpaEntity account, List<ActivityJpaEntity> activities, Long withdrawalBalance, Long depositBalance) {
        return Account.withId(
            new AccountId(account.getId()),
            getBaselineBalance(withdrawalBalance, depositBalance),
            mapToActivityWindow(activities)
        );
    }

    private Money getBaselineBalance(Long withdrawalBalance, Long depositBalance) {
        return Money.subtract(
            Money.of(depositBalance),
            Money.of(withdrawalBalance)
        );
    }

    ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
        return new ActivityWindow(
            activities.stream()
                .map(activity -> new Activity(
                    new ActivityId(activity.getId()),
                    new AccountId(activity.getOwnerAccountId()),
                    new AccountId(activity.getSourceAccountId()),
                    new AccountId(activity.getTargetAccountId()),
                    activity.getTimestamp(),
                    Money.of(activity.getAmount())
                ))
                .collect(Collectors.toList()));
    }

    ActivityJpaEntity mapToJpaEntity(Activity activity) {
        return new ActivityJpaEntity(
            activity.getId() == null ? null : activity.getId().getValue(),
            activity.getTimestamp(),
            activity.getOwnerAccountId().getValue(),
            activity.getSourceAccountId().getValue(),
            activity.getTargetAccountId().getValue(),
            activity.getMoney().getAmount().longValue()
        );
    }

}
