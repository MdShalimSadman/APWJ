package com.controller;

import com.domain.Currency;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CurrencyController {


    @RequestMapping("/currency/rate/from/{from}/to/{to}")
    public Currency rate(@PathVariable("from")String from, @PathVariable("to") String to)  {
        Currency currency = new Currency();
        if(from.equals("USD") && to.equals("BDT")){
            currency.setRate(80.0);
        } else if (from.equals("BDT") && to.equals("USD")) {
            currency.setRate(0.0012);

        }
        else{
            currency.setRate(0);

        }

        return currency;
    }
}
