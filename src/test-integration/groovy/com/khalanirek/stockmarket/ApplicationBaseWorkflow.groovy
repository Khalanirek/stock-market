package com.khalanirek.stockmarket

import com.khalanirek.stockmarket.company.domain.CompanyCommandFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ActiveProfiles("integration")
@ContextConfiguration(initializers = [DatabaseInitializer.class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationBaseWorkflow extends Specification {

    @Autowired
    CompanyCommandFacade companyFacade

    @Autowired
    TestWebClient webClient

}
