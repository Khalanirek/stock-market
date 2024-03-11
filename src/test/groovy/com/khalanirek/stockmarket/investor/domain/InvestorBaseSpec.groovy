package com.khalanirek.stockmarket.investor.domain

import spock.lang.Specification

class InvestorBaseSpec extends Specification {

    InvestorRepository investorRepository = new InMemoryInvestorRepository()
    InvestorConfiguration investorConfiguration = new InvestorConfiguration(investorRepository)
    InvestorCommandFacade investorCommandFacade = investorConfiguration.investorCommandFacade()
    InvestorQueryFacade investorQueryFacade = investorConfiguration.investorQueryFacade()

}
