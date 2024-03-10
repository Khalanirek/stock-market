package com.khalanirek.stockmarket.company.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
class CompanyConfiguration {

    private final CompanyRepository companyRepository;


    @Bean
    CompanyCommandFacade companyCommandFacade() {
        return new CompanyCommandFacade(companyRepository);
    }

    @Bean
    CompanyQueryFacade companyQueryFacade() {
        return new CompanyQueryFacade(companyRepository);
    }

}
