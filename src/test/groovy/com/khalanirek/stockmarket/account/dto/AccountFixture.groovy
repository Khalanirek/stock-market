package com.khalanirek.stockmarket.account.dto

import com.khalanirek.stockmarket.investor.dto.InvestorId

class AccountFixture {

    static final String ACCOUNT_API_BASE_URL = "/api/accounts"
    static final UUID ACCOUNT_A_ID_UUID = UUID.randomUUID()
    static final AccountId ACCOUNT_A_ID = AccountId.of(ACCOUNT_A_ID_UUID)
    static final UUID ACCOUNT_A_OWNER_ID_UUID = UUID.randomUUID()
    static final InvestorId ACCOUNT_A_OWNER_ID = InvestorId.of(ACCOUNT_A_OWNER_ID_UUID)
    static final BigDecimal ACCOUNT_A_BALANCE = 0

    static class Dto {

        static AccountDto.Account accountA() {
            return AccountDto.Account.builder()
                    .id(ACCOUNT_A_ID)
                    .ownerId(ACCOUNT_A_OWNER_ID)
                    .availableBalance(ACCOUNT_A_BALANCE)
                    .build()
        }

    }

    static class Api {

        static AccountApi.AccountDetails accountADetails() {
            return AccountApi.AccountDetails.builder()
                    .id(ACCOUNT_A_ID_UUID)
                    .ownerId(ACCOUNT_A_OWNER_ID_UUID)
                    .availableBalance(ACCOUNT_A_BALANCE)
                    .build()
        }

    }

}
