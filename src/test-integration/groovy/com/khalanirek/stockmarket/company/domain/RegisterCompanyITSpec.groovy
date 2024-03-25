package com.khalanirek.stockmarket.company.domain

import com.khalanirek.stockmarket.ApplicationBaseWorkflow

import static com.khalanirek.stockmarket.company.dto.CompanyFixture.Api.registerCompanyARequest
import static com.khalanirek.stockmarket.company.dto.OwnerType.SELF

class RegisterCompanyITSpec extends ApplicationBaseWorkflow {

    def "should register company"() {
        given:
            def registerCompanyRequest = registerCompanyARequest()
        when:
            def companyId = webClient.company.registerCompany(registerCompanyRequest)
        then: "investor is created"
            def companyDetails = webClient.company.getCompanyDetails(companyId)
        verifyAll(companyDetails) {
            id != null
            name == registerCompanyRequest.name
            symbol == registerCompanyRequest.symbol
            shareCapital == registerCompanyRequest.shareCapital
            sharesQuantity == registerCompanyRequest.sharesQuantity
            shares.size() == 1
            shares[0].owner.ownerId == companyId
            shares[0].owner.ownerType == SELF
            shares[0].quantity == registerCompanyRequest.sharesQuantity
        }
    }

}
