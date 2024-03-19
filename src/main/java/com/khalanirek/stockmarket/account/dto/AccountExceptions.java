package com.khalanirek.stockmarket.account.dto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountExceptions {

    public static class NotEnoughFundsException extends RuntimeException {

        public NotEnoughFundsException(AccountId accountId) {
            super("Not enough funds for account with id " + accountId);
        }

    }

}
