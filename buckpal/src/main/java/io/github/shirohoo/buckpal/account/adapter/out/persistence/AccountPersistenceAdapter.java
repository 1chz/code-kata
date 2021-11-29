package io.github.shirohoo.buckpal.account.adapter.out.persistence;

import io.github.shirohoo.buckpal.account.application.port.out.LoadAccountPort;
import io.github.shirohoo.buckpal.account.application.port.out.UpdateAccountStatePort;
import io.github.shirohoo.buckpal.account.application.domain.Account;
import io.github.shirohoo.buckpal.account.application.domain.Account.AccountId;
import io.github.shirohoo.buckpal.common.PersistenceAdapter;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final SpringDataAccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {
        AccountJpaEntity account = accountRepository.findById(accountId.getValue())
            .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(accountId.getValue(), baselineDate);

        Long withdrawalBalance = orZero(activityRepository.getWithdrawalBalanceUntil(accountId.getValue(), baselineDate));

        Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(accountId.getValue(), baselineDate));

        return accountMapper.mapToDomainEntity(account, activities, withdrawalBalance, depositBalance);
    }

    private Long orZero(Long value) {
        return value == null ? 0L : value;
    }


    @Override
    public void updateActivities(Account account) {
        account.getActivityWindow().getActivities().stream()
            .filter(activity -> activity.getId() == null)
            .map(accountMapper::mapToJpaEntity)
            .forEach(activityRepository::save);
    }

}
