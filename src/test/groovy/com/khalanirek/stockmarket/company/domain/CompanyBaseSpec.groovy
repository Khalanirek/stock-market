package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.common.TestApplicationEventPublisher
import com.khalanirek.stockmarket.common.TimeContext
import com.khalanirek.stockmarket.common.UUIDContext
import spock.lang.Specification

class CompanyBaseSpec extends Specification {

    TestApplicationEventPublisher applicationEventPublisher = new TestApplicationEventPublisher()
    CompanyRepository companyRepository = new InMemoryCompanyRepository()
    CompanyConfiguration companyConfiguration = new CompanyConfiguration(applicationEventPublisher, companyRepository)
    CompanyCommandFacade companyCommandFacade = companyConfiguration.companyCommandFacade()
    CompanyQueryFacade companyQueryFacade = companyConfiguration.companyQueryFacade()

    def cleanup() {
        TimeContext.clear()
        UUIDContext.clear()
        applicationEventPublisher.clear()
    }

}
