package edu.mylearning.utilities.currency.converter.exchange;

import edu.mylearning.utilities.currency.converter.currency.Currency;

import java.util.HashMap;
import java.util.Map;

public class SimpleExchangeRateProvider implements ExchangeRateProvider{

    private final Map<String, Double> rates = new HashMap<>();

    public SimpleExchangeRateProvider() {
        this.rates.put("USD-INR", 74.85);
        this.rates.put("INR-USD", 0.013);
    }

    @Override
    public double getRate(Currency source, Currency target) {
        return this.rates.getOrDefault(source.getCode() + "-" + target.getCode(), 1.0);
    }
}
