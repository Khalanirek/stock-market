package com.khalanirek.stockmarket.account.domain

import com.khalanirek.stockmarket.account.dto.AccountExceptions
import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext

import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_OWNER_ID
import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_ID_UUID
import static com.khalanirek.stockmarket.account.dto.AccountFixture.Dto.accountA

class AccountFacadeSpec extends AccountBaseSpec {

    def "should create account for investor"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
        when:
            def accountId= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
        then:
            accountQueryFacade.findAccountById(accountId) == accountA()
    }

    def "should deposit money"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
            def accountId= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
            def deposit = 1000 as BigDecimal
        when:
            accountCommandFacade.depositFunds(accountId, deposit)
        then:
            def account = accountQueryFacade.findAccountById(accountId)
            account.getAvailableBalance() == deposit

    }

    def "should withdraw money"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
            def accountId= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
            def deposit = 1000 as BigDecimal
            accountCommandFacade.depositFunds(accountId, deposit)
        when:
            accountCommandFacade.withdrawFunds(accountId, deposit)
        then:
            def account = accountQueryFacade.findAccountById(accountId)
            account.getAvailableBalance() == 0
    }

    def "should throw NotEnoughFundsException when try to withdraw more than available on account"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
            def accountId= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
        when:
            accountCommandFacade.withdrawFunds(accountId, 1000 as BigDecimal)
        then:
            def e = thrown(AccountExceptions.NotEnoughFundsException)
            e.message == "Not enough funds for account with id " + accountId
    }

    def "should block funds on account"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
            def accountId= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
            def deposit = 1000 as BigDecimal
            accountCommandFacade.depositFunds(accountId, deposit)
        when:
            accountCommandFacade.blockFunds(accountId, deposit, TimeContext.zonedNow().plusMonths(1))
        then:
            def account = accountQueryFacade.findAccountById(accountId)
            account.getAvailableBalance() == 0
    }

}
