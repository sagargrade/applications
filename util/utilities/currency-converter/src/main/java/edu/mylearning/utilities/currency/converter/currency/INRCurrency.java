package edu.mylearning.utilities.currency.converter.currency;

public class INRCurrency implements Currency{
    @Override
    public String getCode() {
        return "INR";
    }

    @Override
    public String getSymbol() {
        return "₹";
    }
}
