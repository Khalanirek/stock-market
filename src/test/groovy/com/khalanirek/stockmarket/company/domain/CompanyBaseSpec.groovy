package com.khalanirek.stockmarket.company.domain

import spock.lang.Specification

class CompanyBaseSpec extends Specification {

    CompanyRepository companyRepository = new InMemoryCompanyRepository()
    CompanyConfiguration companyConfiguration = new CompanyConfiguration(companyRepository)
    CompanyCommandFacade companyCommandFacade = companyConfiguration.companyCommandFacade()
    CompanyQueryFacade companyQueryFacade = companyConfiguration.companyQueryFacade()

}
