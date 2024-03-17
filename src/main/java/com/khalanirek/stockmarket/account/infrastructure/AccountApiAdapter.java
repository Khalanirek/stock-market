package com.khalanirek.stockmarket.account.infrastructure;

import com.khalanirek.stockmarket.account.dto.AccountApi;
import com.khalanirek.stockmarket.account.dto.AccountDto;
import lombok.experimental.UtilityClass;

@UtilityClass
class AccountApiAdapter {

    static class DtoToApi {

        static AccountApi.AccountDetails toAccountDetails(AccountDto.Account dto) {
            return AccountApi.AccountDetails.builder()
                    .id(dto.getId().getId())
                    .ownerId(dto.getOwnerId().getId())
                    .balance(dto.getBalance())
                    .build();
        }

    }

}
