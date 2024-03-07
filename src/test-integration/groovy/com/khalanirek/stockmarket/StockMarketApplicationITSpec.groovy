package com.khalanirek.stockmarket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class StockMarketApplicationITSpec extends ApplicationBaseWorkflow {

    @Autowired
    ApplicationContext context

    def "should load context"() {
        expect:
            context != null
    }

}
