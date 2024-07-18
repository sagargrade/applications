package edu.mylearning.utilities.currency.converter.currency;

public class USDCurrency implements Currency{
    @Override
    public String getCode() {
        return "USD";
    }

    @Override
    public String getSymbol() {
        return "$";
    }
}
