package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.common.UUIDContext
import com.khalanirek.stockmarket.company.dto.CompanyDto

import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_ID_UUID
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_NAME
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SHARES_QUANTITY
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SHARE_CAPITAL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SYMBOL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Dto.registerCompanyA
import static com.khalanirek.stockmarket.company.dto.OwnerType.SELF

class CompanyFacadeSpec extends CompanyBaseSpec {

    def "should register company"() {
        given:
            UUIDContext.setFixtureUUID(COMPANY_A_ID_UUID)
            def expectedShares = Set.of(CompanyDto.Company.Share.builder()
                    .owner(CompanyDto.Company.Share.Owner.builder()
                            .ownerId(COMPANY_A_ID_UUID)
                            .ownerType(SELF)
                            .build())
                    .quantity(COMPANY_A_SHARES_QUANTITY)
                    .build())
        when:
            def id = companyCommandFacade.registerCompany(registerCompanyA())
        then:
            def company = companyQueryFacade.findCompanyById(id)
            verifyAll(company) {
                name == COMPANY_A_NAME
                symbol == COMPANY_A_SYMBOL
                shareCapital == COMPANY_A_SHARE_CAPITAL
                sharesQuantity == COMPANY_A_SHARES_QUANTITY
                shares == expectedShares
            }
    }

}
