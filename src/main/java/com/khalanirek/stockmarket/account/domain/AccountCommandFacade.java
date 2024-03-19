package com.khalanirek.stockmarket.account.domain;

import com.khalanirek.stockmarket.account.dto.AccountId;
import com.khalanirek.stockmarket.investor.dto.InvestorId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Transactional
public class AccountCommandFacade {

    private AccountRepository accountRepository;
    public AccountId createAccount(InvestorId investorId) {
        Account account = AccountFactory.createAccount(investorId);
        return accountRepository.save(account).id();
    }

    public void blockFunds(AccountId accountId, BigDecimal amount, ZonedDateTime expirationTime) {
        Account account = accountRepository.findById(accountId.getId()).orElseThrow();
        account.blockFunds(amount, expirationTime);
    }

    public void depositFunds(AccountId accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId.getId()).orElseThrow();
        account.depositFunds(amount);
    }

    public void withdrawFunds(AccountId accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId.getId()).orElseThrow();
        account.withdrawFunds(amount);
    }

}
