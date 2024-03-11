package com.khalanirek.stockmarket.company.domain

import spock.lang.Specification

class CompanyInvestorBaseSpec extends Specification {

    CompanyRepository companyRepository = new InMemoryCompanyRepository()
    CompanyConfiguration companyConfiguration = new CompanyConfiguration(companyRepository)
    CompanyCommandFacade companyCommandFacade = companyConfiguration.companyCommandFacade()
    CompanyQueryFacade companyQueryFacade = companyConfiguration.companyQueryFacade()

}
