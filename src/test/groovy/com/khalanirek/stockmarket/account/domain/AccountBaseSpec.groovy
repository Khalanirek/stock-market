package com.khalanirek.stockmarket.account.domain

import com.khalanirek.stockmarket.common.TestApplicationEventPublisher
import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext
import spock.lang.Specification

class AccountBaseSpec extends Specification {

    TestApplicationEventPublisher applicationEventPublisher = new TestApplicationEventPublisher()
    AccountRepository accountRepository = new InMemoryAccountRepository()
    AccountConfiguration accountConfiguration = new AccountConfiguration(applicationEventPublisher, accountRepository)
    AccountCommandFacade accountCommandFacade = accountConfiguration.accountCommandFacade()
    AccountQueryFacade accountQueryFacade = accountConfiguration.accountQueryFacade()

    def cleanup() {
        TimeContext.clear()
        UUIDContext.clear()
        applicationEventPublisher.clear()
    }

}
