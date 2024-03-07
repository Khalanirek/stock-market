package com.khalanirek.stockmarket.company.domain

import spock.lang.Specification

class CompanyBaseSpec extends Specification {

    CompanyRepository companyRepository = new InMemoryCompanyRepository()
    CompanyConfiguration companyConfiguration = new CompanyConfiguration(companyRepository)
    CompanyFacade companyFacade = companyConfiguration.companyFacade()

}
