package edu.mylearning.utilities.currency.converter.converter;

import edu.mylearning.utilities.currency.converter.currency.Currency;
import edu.mylearning.utilities.currency.converter.exchange.ExchangeRateProvider;

public class SimpleCurrencyConverter implements CurrencyConverter{
    private final ExchangeRateProvider exchangeRateProvider;

    public SimpleCurrencyConverter(ExchangeRateProvider exchangeRateProvider){
        this.exchangeRateProvider = exchangeRateProvider;
    }

    @Override
    public double convert(Currency source, Currency target, double amount) {
        double rate = exchangeRateProvider.getRate(source, target);
        return amount * rate;
    }
}
