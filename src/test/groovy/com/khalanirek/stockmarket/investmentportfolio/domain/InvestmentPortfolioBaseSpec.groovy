package com.khalanirek.stockmarket.investmentportfolio.domain

import spock.lang.Specification

class InvestmentPortfolioBaseSpec extends Specification{

    InvestmentPortfolioRepository investmentPortfolioRepository = new InMemoryInvestmentPortfolioRepository()
    InvestmentPortfolioConfiguration investmentPortfolioConfiguration = new InvestmentPortfolioConfiguration(investmentPortfolioRepository)
    InvestmentPortfolioCommandFacade investmentPortfolioCommandFacade = investmentPortfolioConfiguration.investmentPortfolioCommandFacade()
    InvestmentPortfolioQueryFacade investmentPortfolioQueryFacade = investmentPortfolioConfiguration.investmentPortfolioQueryFacade()

}
