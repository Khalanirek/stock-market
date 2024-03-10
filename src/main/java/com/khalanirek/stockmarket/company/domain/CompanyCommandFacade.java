package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
public class CompanyCommandFacade {

    private final CompanyRepository companyRepository;

    public CompanyId registerCompany(CompanyDto.RegisterCompany dto) {
        Company company = CompanyFactory.createCompany(dto);
        return companyRepository.save(company).id();
    }

}
