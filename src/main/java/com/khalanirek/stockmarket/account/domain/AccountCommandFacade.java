package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class AccountCommandFacade {

    private AccountRepository accountRepository;
    public AccountId createAccount(InvestorId investorId) {
        Account account = AccountFactory.createAccount(investorId);
        return accountRepository.save(account).id();
    }

}
