package com.khalanirek.stockmarket.company.domain;

import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional(readOnly = true)
public class CompanyQueryFacade {

    private final CompanyRepository companyRepository;

    public CompanyDto.Company findCompanyById(CompanyId id) {
        return companyRepository.findById(id.getId())
                .orElseThrow()
                .toDto();
    }

}
