package edu.mylearning.utilities.currency.converter.exchange;

import edu.mylearning.utilities.currency.converter.currency.Currency;
import edu.mylearning.utilities.currency.converter.currency.INRCurrency;
import edu.mylearning.utilities.currency.converter.currency.USDCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleExchangeRateProviderTest {

    private SimpleExchangeRateProvider simpleExchangeRateProvider;

    @BeforeEach
    public void setUp(){
        simpleExchangeRateProvider = new SimpleExchangeRateProvider();
    }

    @Test
    @DisplayName("should get rates from USD to INR conversion")
    public void testGetRate_USDToINR(){
        //arrange
        //act
        double rate = simpleExchangeRateProvider.getRate(new USDCurrency(), new INRCurrency());
        //assert
        assertEquals(74.85, rate);
    }

    @Test
    @DisplayName("should get rates from INR to USD conversion")
    public void testGetRate_INRToUSD(){
        //arrange
        //act
        double rate = simpleExchangeRateProvider.getRate(new INRCurrency(), new USDCurrency());
        //assert
        assertEquals(0.013, rate);
    }

    @Test
    @DisplayName("should return rate as 1 for invalid currency")
    public void testGetRate_InvalidCurrency(){
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
        //act
        double rate = simpleExchangeRateProvider.getRate(new USDCurrency(), invalidCurrency);
        //assert
        assertEquals(1.0, rate);
    }
}