package com.khalanirek.stockmarket

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("integration")
@Configuration
class TestConfiguration {

    @Autowired
    private final TestRestTemplate restTemplate

    @Bean
    TestWebClient testWebClient() {
        return new TestWebClient(restTemplate)
    }

}
