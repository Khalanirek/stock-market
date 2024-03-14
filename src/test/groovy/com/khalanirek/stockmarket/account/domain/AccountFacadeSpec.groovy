package com.khalanirek.stockmarket.account.domain

import com.khalanirek.stockmarket.common.UUIDContext

import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_OWNER_ID
import static com.khalanirek.stockmarket.account.dto.AccountFixture.ACCOUNT_A_ID_UUID
import static com.khalanirek.stockmarket.account.dto.AccountFixture.Dto.accountA

class AccountFacadeSpec extends AccountBaseSpec {

    def "should create account for investor"() {
        given:
            UUIDContext.setFixtureUUID(ACCOUNT_A_ID_UUID)
        when:
            def id= accountCommandFacade.createAccount(ACCOUNT_A_OWNER_ID)
        then:
            accountQueryFacade.findAccountById(id) == accountA()
    }

}
