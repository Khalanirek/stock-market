package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Transactional
class CompanyFacade {

    private final CompanyRepository companyRepository;

    public UUID registerCompany(CompanyDto.RegisterCompany dto) {
        Company company = CompanyFactory.createCompany(dto);
        return companyRepository.save(company).id().getId();
    }

    public CompanyDto.Company findCompanyById(CompanyId id) {
        return companyRepository.findById(id.getId())
                .orElseThrow()
                .toDto();
    }

}
