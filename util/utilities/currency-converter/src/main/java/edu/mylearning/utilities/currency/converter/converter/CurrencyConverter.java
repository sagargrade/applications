package edu.mylearning.utilities.currency.converter.converter;

import edu.mylearning.utilities.currency.converter.currency.Currency;

public interface CurrencyConverter {
    double convert(Currency source, Currency target, double amount);
}
