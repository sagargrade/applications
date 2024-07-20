package edu.mylearning.utilities.currency.converter.converter;

import edu.mylearning.utilities.currency.converter.currency.Currency;
import edu.mylearning.utilities.currency.converter.currency.INRCurrency;
import edu.mylearning.utilities.currency.converter.currency.USDCurrency;
import edu.mylearning.utilities.currency.converter.exchange.SimpleExchangeRateProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleCurrencyConverterTest {
    private SimpleCurrencyConverter simpleCurrencyConverter;
    private final SimpleExchangeRateProvider simpleExchangeRateProvider = mock(SimpleExchangeRateProvider.class);

    @BeforeEach
    public void setUp(){
        simpleCurrencyConverter = new SimpleCurrencyConverter(simpleExchangeRateProvider);
    }

    @Test
    @DisplayName("should convert amount from USD to INR")
    public void testConvert_USDtoINR(){
        //arrange
        when(simpleExchangeRateProvider.getRate(any(), any())).thenReturn(74.85);
        //act
        double convertAmount = simpleCurrencyConverter.convert(new USDCurrency(), new INRCurrency(), 100.0);
        //assert
        assertEquals(7485.0, convertAmount);
    }

    @Test
    @DisplayName("should convert amount from INR to USD")
    public void testConvert_INRToUSD() {
        //arrange
        when(simpleExchangeRateProvider.getRate(any(), any())).thenReturn(0.013);
        //act
        double convertAmount = simpleCurrencyConverter.convert(new INRCurrency(), new USDCurrency(), 100.0);
        //assert
        assertEquals(1.0, convertAmount);
    }

    @Test
    @DisplayName("should not convert amount from USD to invalid currency")
    public void testConvert_USDToInvalidCurrency() {
        //arrange
        Currency invalidCurrency = new Currency() {
            @Override
            public String getCode() {
                return "FAKE";
            }

            @Override
            public String getSymbol() {
                return "F";
            }
        };
        when(simpleExchangeRateProvider.getRate(any(), any())).thenReturn(1.0);
        //act
        double convertAmount = simpleCurrencyConverter.convert(new USDCurrency(), invalidCurrency, 100.0);
        //assert
        assertEquals(100.0, convertAmount);
    }

}