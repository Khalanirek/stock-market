package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.common.UUIDContext

import static com.khalanirek.stockmarket.company.dto.CompanyFixture.COMPANY_A_ID_UUID
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Dto.companyA
import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Dto.registerCompanyA

class CompanyFacadeSpec extends CompanyInvestorBaseSpec {

    def "should register company"() {
        given:
            UUIDContext.setFixtureUUID(COMPANY_A_ID_UUID)
        when:
            def id = companyCommandFacade.registerCompany(registerCompanyA())
        then:
            companyQueryFacade.findCompanyById(id) == companyA()
    }

}
