package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class CompanyCommandFacade {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyRepository companyRepository;

    public CompanyId registerCompany(CompanyDto.RegisterCompany dto) {
        Company company = CompanyFactory.Domain.createCompany(dto);
        companyRepository.save(company);
        applicationEventPublisher.publishEvent(CompanyFactory.EventsDto.toCompanyRegistered(company));
        return company.id();
    }

}
