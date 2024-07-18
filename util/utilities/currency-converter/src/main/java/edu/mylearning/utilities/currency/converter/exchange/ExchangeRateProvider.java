package edu.mylearning.utilities.currency.converter.exchange;

import edu.mylearning.utilities.currency.converter.currency.Currency;

public interface ExchangeRateProvider {
    double getRate(Currency source, Currency target);
}
