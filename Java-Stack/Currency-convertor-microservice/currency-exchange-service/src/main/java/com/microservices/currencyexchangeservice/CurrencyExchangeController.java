package com.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private CurrencyExchangeRepo currencyExchangeRepo;
    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepo currencyExchangeRepo){
        this.environment=environment;
        this.currencyExchangeRepo=currencyExchangeRepo;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){

        logger.info("retrieveExchangeValue called with {} to {}",from, to);

        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
        if(currencyExchange == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

        return currencyExchange;
    }
}
