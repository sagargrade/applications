package edu.mylearning.utilities.currency.converter.cli;

import edu.mylearning.utilities.currency.converter.converter.CurrencyConverter;
import edu.mylearning.utilities.currency.converter.currency.Currency;
import edu.mylearning.utilities.currency.converter.currency.INRCurrency;
import edu.mylearning.utilities.currency.converter.currency.USDCurrency;

import java.util.Scanner;

public class CurrencyConverterCLI {
    private final CurrencyConverter converter;

    public CurrencyConverterCLI(CurrencyConverter currencyConverter){
        this.converter = currencyConverter;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount : ");
        double amount = scanner.nextDouble();
        System.out.println("Enter source currency code (e.g., USD) : ");
        String sourceCurrency = scanner.next().toUpperCase();
        System.out.println("Enter target currency code (e.g., INR) : ");
        String targetCurrency = scanner.next().toUpperCase();

        Currency source = getCurrency(sourceCurrency);
        Currency target = getCurrency(targetCurrency);

        if (source != null && target != null){
            double result = converter.convert(source, target, amount);
            System.out.println("Converted amount : " + result + " " + target.getSymbol());
        } else {
            System.out.println("Invalid currency code.!!!");
        }
    }

    private Currency getCurrency(String code) {
        switch (code){
            case "USD": return new USDCurrency();
            case "INR": return new INRCurrency();
            default: return null;
        }
    }
}
