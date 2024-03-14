package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.common.UUIDContext
import spock.lang.Specification

class CompanyBaseSpec extends Specification {

    CompanyRepository companyRepository = new InMemoryCompanyRepository()
    CompanyConfiguration companyConfiguration = new CompanyConfiguration(companyRepository)
    CompanyCommandFacade companyCommandFacade = companyConfiguration.companyCommandFacade()
    CompanyQueryFacade companyQueryFacade = companyConfiguration.companyQueryFacade()

    def cleanup() {
        UUIDContext.clear()
    }

}
