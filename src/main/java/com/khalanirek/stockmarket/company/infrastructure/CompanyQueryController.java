package com.khalanirek.stockmarket.company.infrastructure;

import com.khalanirek.stockmarket.company.domain.CompanyQueryFacade;
import com.khalanirek.stockmarket.company.dto.CompanyApi;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import com.khalanirek.stockmarket.company.dto.CompanyId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
class CompanyQueryController {

    private final CompanyQueryFacade companyQueryFacade;

    @GetMapping("/{companyId}")
    public CompanyApi.CompanyDetails getCompanyDetails(@PathVariable UUID companyId) {
        CompanyDto.Company company = companyQueryFacade.findCompanyById(CompanyId.of(companyId));
        return CompanyApiAdapter.DtoToApi.toCompanyDetails(company);
    }

}
