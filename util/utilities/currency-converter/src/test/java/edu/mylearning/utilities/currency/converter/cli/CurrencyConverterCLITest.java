package edu.mylearning.utilities.currency.converter.cli;

import edu.mylearning.utilities.currency.converter.converter.CurrencyConverter;
import edu.mylearning.utilities.currency.converter.converter.SimpleCurrencyConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CurrencyConverterCLITest {

    private CurrencyConverterCLI currencyConverterCLI;
    private final CurrencyConverter currencyConverter = mock(SimpleCurrencyConverter.class);

    @BeforeEach
    public void setUp(){
        currencyConverterCLI = new CurrencyConverterCLI(currencyConverter);
    }

    @Test
    @DisplayName("should convert the amount entered and show result")
    public void testStart() {
        //arrange
        // Simulate user input
        String input = "100\nUSD\nINR";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        // Capture the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        when(currencyConverter.convert(any(), any(), anyDouble())).thenReturn(7485.0);
        String expectedOutput = "Enter amount : \nEnter source currency code (e.g., USD) : \nEnter target currency code (e.g., INR) : \nConverted amount : 7485.0 ₹\n";
        // Normalize whitespace and line endings
        expectedOutput = expectedOutput.replaceAll("\\s+", " ").trim();
        //act
        currencyConverterCLI.start();
        String actualOutput = byteArrayOutputStream.toString();
        // Normalize whitespace and line endings
        actualOutput = actualOutput.replaceAll("\\s+", " ").trim();
        //assert
        assertEquals(expectedOutput, actualOutput);
    }
}