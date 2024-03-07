package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.common.UUIDContext
import com.khalanirek.stockmarket.company.dto.CompanyDto
import com.khalanirek.stockmarket.company.dto.CompanyId

import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_ID
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_NAME
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SHARES_QUANTITY
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SHARE_CAPITAL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_SYMBOL
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.registerCompanyA
import static com.khalanirek.stockmarket.company.dto.OwnerType.SELF

class CompanyFacadeSpec extends CompanyBaseSpec {

    def "should register company"() {
        given:
            UUIDContext.setFixtureUUID(COMPANY_A_ID)
            def expectedShares = Set.of(CompanyDto.Company.Share.builder()
                    .owner(CompanyDto.Company.Share.Owner.builder()
                            .ownerId(COMPANY_A_ID)
                            .ownerType(SELF)
                            .build())
                    .quantity(COMPANY_A_SHARES_QUANTITY)
                    .build())
        when:
            def id = companyFacade.registerCompany(registerCompanyA())
        then:
            def company = companyFacade.findCompanyById(CompanyId.of(id))
            verifyAll(company) {
                name == COMPANY_A_NAME
                symbol == COMPANY_A_SYMBOL
                shareCapital == COMPANY_A_SHARE_CAPITAL
                sharesQuantity == COMPANY_A_SHARES_QUANTITY
                shares == expectedShares
            }
    }

}
