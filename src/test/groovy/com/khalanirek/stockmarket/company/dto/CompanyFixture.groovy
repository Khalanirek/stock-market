package com.khalanirek.stockmarket.company.dto

class CompanyFixture {

    static final UUID COMPANY_A_ID = UUID.randomUUID()
    static final String COMPANY_A_NAME = "Company A"
    static final String COMPANY_A_SYMBOL = "CPA"
    static final BigDecimal COMPANY_A_SHARE_CAPITAL = 1_000_000
    static final int COMPANY_A_SHARES_QUANTITY = 1_000

    static CompanyDto.RegisterCompany registerCompanyA() {
        return CompanyDto.RegisterCompany.builder()
                .name(COMPANY_A_NAME)
                .symbol(COMPANY_A_SYMBOL)
                .shareCapital(COMPANY_A_SHARE_CAPITAL)
                .sharesQuantity(COMPANY_A_SHARES_QUANTITY)
                .build()
    }

}
