package com.khalanirek.stockmarket.account.infrastructure;

import com.khalanirek.stockmarket.account.domain.AccountQueryFacade;
import com.khalanirek.stockmarket.account.dto.AccountApi;
import com.khalanirek.stockmarket.account.dto.AccountDto;
import com.khalanirek.stockmarket.account.dto.AccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountQueryController {

    private final AccountQueryFacade accountQueryFacade;

    @GetMapping("/{accountId}")
    public AccountApi.AccountDetails getAccountDetails(@PathVariable UUID accountId) {
        AccountDto.Account account = accountQueryFacade.findAccountById(AccountId.of(accountId));
        return AccountApiAdapter.DtoToApi.toAccountDetails(account);
    }

}
