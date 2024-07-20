package edu.mylearning.utilities.currency.converter;

import edu.mylearning.utilities.currency.converter.cli.CurrencyConverterCLI;
import edu.mylearning.utilities.currency.converter.converter.CurrencyConverter;
import edu.mylearning.utilities.currency.converter.converter.SimpleCurrencyConverter;
import edu.mylearning.utilities.currency.converter.exchange.ExchangeRateProvider;
import edu.mylearning.utilities.currency.converter.exchange.SimpleExchangeRateProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterAppEndToEndTest {
    private CurrencyConverterCLI cli;

    @BeforeEach
    public void setUp(){
        ExchangeRateProvider exchangeRateProvider = new SimpleExchangeRateProvider();
        CurrencyConverter currencyConverter = new SimpleCurrencyConverter(exchangeRateProvider);
        cli = new CurrencyConverterCLI(currencyConverter);
    }

    @Test
    public void testEndToEndCurrencyConversion_USDToINR() {
        //arrange
        String input = "100\nUSD\nINR\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutput = "Enter amount : \nEnter source currency code (e.g., USD) : \nEnter target currency code (e.g., INR) : \nConverted amount : 7485.0 ₹\n";
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        //act
        cli.start();
        String actualOutput = out.toString();
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        //assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEndToEndCurrencyConversion_INRToUSD() {
        //arrange
        String input = "100\nINR\nUSD\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutput = "Enter amount : \nEnter source currency code (e.g., USD) : \nEnter target currency code (e.g., INR) : \nConverted amount : 1.0 $\n";
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        //act
        cli.start();
        String actualOutput = out.toString();
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        //assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEndToEndCurrencyConversion_USDToFAKE() {
        //arrange
        String input = "100\nUSD\nFAKE\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String expectedOutput = "Enter amount : \nEnter source currency code (e.g., USD) : \nEnter target currency code (e.g., INR) : \nInvalid currency code.!!!\n";
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        //act
        cli.start();
        String actualOutput = out.toString();
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        //assert
        assertEquals(expectedOutput, actualOutput);
    }
}
