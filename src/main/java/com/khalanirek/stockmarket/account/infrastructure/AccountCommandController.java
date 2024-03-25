package com.khalanirek.stockmarket.account.infrastructure;

import com.khalanirek.stockmarket.account.domain.AccountCommandFacade;
import com.khalanirek.stockmarket.account.dto.AccountId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountCommandController {

    private final AccountCommandFacade accountCommandFacade;

    @PostMapping("/{accountId}/deposit")
    public void depositFunds(@PathVariable UUID accountId, @RequestParam BigDecimal amount) {
        accountCommandFacade.depositFunds(AccountId.of(accountId), amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdrawFunds(@PathVariable UUID accountId, @RequestParam BigDecimal amount) {
        accountCommandFacade.withdrawFunds(AccountId.of(accountId), amount);
    }

}
