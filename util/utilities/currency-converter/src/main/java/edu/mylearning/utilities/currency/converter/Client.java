package edu.mylearning.utilities.currency.converter;

import edu.mylearning.utilities.currency.converter.cli.CurrencyConverterCLI;
import edu.mylearning.utilities.currency.converter.converter.CurrencyConverter;
import edu.mylearning.utilities.currency.converter.converter.SimpleCurrencyConverter;
import edu.mylearning.utilities.currency.converter.exchange.ExchangeRateProvider;
import edu.mylearning.utilities.currency.converter.exchange.SimpleExchangeRateProvider;

public class Client {
    public static void main(String[] args) {
        ExchangeRateProvider rateProvider = new SimpleExchangeRateProvider();
        CurrencyConverter currencyConverter = new SimpleCurrencyConverter(rateProvider);
        CurrencyConverterCLI cli = new CurrencyConverterCLI(currencyConverter);
        cli.start();
    }
}
