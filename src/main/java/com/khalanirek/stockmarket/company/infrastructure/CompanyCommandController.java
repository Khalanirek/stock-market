package com.khalanirek.stockmarket.company.infrastructure;

import com.khalanirek.stockmarket.company.domain.CompanyCommandFacade;
import com.khalanirek.stockmarket.company.dto.CompanyApi;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyCommandController {

    private final CompanyCommandFacade companyCommandFacade;

    @PostMapping
    public UUID registerCompany(@RequestBody CompanyApi.RegisterCompanyRequest request) {
        CompanyDto.RegisterCompany registerCompany = CompanyApiAdapter.ApiToDto.toRegisterCompany(request);
        return companyCommandFacade.registerCompany(registerCompany).getId();
    }

}
