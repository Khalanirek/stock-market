package com.khalanirek.stockmarket.company.dto

import com.khalanirek.stockmarket.common.BaseFixture

import static com.khalanirek.stockmarket.company.dto.OwnerType.SELF

class CompanyFixture extends BaseFixture {

    static final String COMPANY_API_BASE_URL = "/api/companies"
    static final UUID COMPANY_A_ID_UUID = UUID.randomUUID()
    static final CompanyId COMPANY_A_ID = CompanyId.of(COMPANY_A_ID_UUID)
    static final String COMPANY_A_NAME = "Company A"
    static final String COMPANY_A_SYMBOL = "CPA"
    static final BigDecimal COMPANY_A_SHARE_CAPITAL = 1_000_000
    static final int COMPANY_A_SHARES_QUANTITY = 10_000

    static class Dto {

        static CompanyDto.RegisterCompany registerCompanyA() {
            return CompanyDto.RegisterCompany.builder()
                    .name(COMPANY_A_NAME)
                    .symbol(COMPANY_A_SYMBOL)
                    .shareCapital(COMPANY_A_SHARE_CAPITAL)
                    .sharesQuantity(COMPANY_A_SHARES_QUANTITY)
                    .build()
        }

        static CompanyDto.Company companyA() {
            return CompanyDto.Company.builder()
                    .id(COMPANY_A_ID)
                    .name(COMPANY_A_NAME)
                    .symbol(COMPANY_A_SYMBOL)
                    .shareCapital(COMPANY_A_SHARE_CAPITAL)
                    .sharesQuantity(COMPANY_A_SHARES_QUANTITY)
                    .shares(Set.of(companyASelfShare()))
                    .build()
        }

        static CompanyDto.Company.Share companyASelfShare() {
            return CompanyDto.Company.Share.builder()
                    .owner(CompanyDto.Company.Share.Owner.builder()
                            .ownerId(COMPANY_A_ID_UUID)
                            .ownerType(SELF)
                            .build())
                    .quantity(COMPANY_A_SHARES_QUANTITY)
                    .build()
        }

    }

    static class Api {

        static CompanyApi.RegisterCompanyRequest registerCompanyARequest() {
            return CompanyApi.RegisterCompanyRequest.builder()
                    .name(COMPANY_A_NAME)
                    .symbol(COMPANY_A_SYMBOL)
                    .shareCapital(COMPANY_A_SHARE_CAPITAL)
                    .sharesQuantity(COMPANY_A_SHARES_QUANTITY)
                    .build()
        }

        static CompanyApi.CompanyDetails companyADetails() {
            return CompanyApi.CompanyDetails.builder()
                    .id(COMPANY_A_ID_UUID)
                    .name(COMPANY_A_NAME)
                    .symbol(COMPANY_A_SYMBOL)
                    .shareCapital(COMPANY_A_SHARE_CAPITAL)
                    .sharesQuantity(COMPANY_A_SHARES_QUANTITY)
                    .shares(List.of(companyASelfShare()))
                    .build()
        }

        static CompanyApi.CompanyDetails.Share companyASelfShare() {
            return CompanyApi.CompanyDetails.Share.builder()
                    .owner(CompanyApi.CompanyDetails.Share.Owner.builder()
                            .ownerId(COMPANY_A_ID_UUID)
                            .ownerType(SELF)
                            .build())
                    .quantity(COMPANY_A_SHARES_QUANTITY)
                    .build()
        }

    }

}
