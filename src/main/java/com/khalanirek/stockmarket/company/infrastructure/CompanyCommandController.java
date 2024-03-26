package com.khalanirek.stockmarket.company.infrastructure;

import com.khalanirek.stockmarket.company.domain.CompanyCommandFacade;
import com.khalanirek.stockmarket.company.dto.CompanyApi;
import com.khalanirek.stockmarket.company.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/companies")
public class CompanyCommandController {

    private final CompanyCommandFacade companyCommandFacade;

    @PostMapping
    @ResponseStatus(CREATED)
    public UUID registerCompany(@RequestBody CompanyApi.RegisterCompanyRequest request) {
        CompanyDto.RegisterCompany registerCompany = CompanyApiAdapter.ApiToDto.toRegisterCompany(request);
        return companyCommandFacade.registerCompany(registerCompany).getId();
    }

}
