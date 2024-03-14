package com.khalanirek.stockmarket.account.domain

import com.khalanirek.stockmarket.common.UUIDContext
import spock.lang.Specification

class AccountBaseSpec extends Specification {

    AccountRepository accountRepository = new InMemoryAccountRepository()
    AccountConfiguration accountConfiguration = new AccountConfiguration(accountRepository)
    AccountCommandFacade accountCommandFacade = accountConfiguration.accountCommandFacade()
    AccountQueryFacade accountQueryFacade = accountConfiguration.accountQueryFacade()

    def cleanup() {
        UUIDContext.clear()
    }

}
