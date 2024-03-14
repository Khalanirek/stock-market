package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountDto;
import com.khalanirek.stockmarket.account.dto.AccountId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional(readOnly = true)
public class AccountQueryFacade {

    private final AccountRepository accountRepository;

    public AccountDto.Account findAccountById(AccountId accountId) {
        return accountRepository.findById(accountId.getId())
                .orElseThrow()
                .toDto();
    }

}
