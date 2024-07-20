# Currency Converter

Basic Java Project to convert currency from one to another

## Requirement
1. Identify currencies - List the currencies we want to support, e.g., USD, INR, EUR, etc.
2. Conversion Rates - Decide how we will handle conversion rates. For simplicity, we can hardcode them initially, or use an external service/API.
3. User Interface - Plan for a CLI-based interface where users can input the currency they want to convert from, the currency they want to convert to, and the amount.

# SOLID Principle
1. SRP : 
   `USDCurrency` and `INRCurrency`: These classes represent specific currencies and only contain information about their respective currency codes and symbols.
   `SimpleCurrencyConverter`: This class handles the logic of converting one currency to another using an exchange rate provider.
   `SimpleExchangeRateProvider`: This class is responsible for providing exchange rates between different currencies.
   `CurrencyConverterCLI`: This class manages the user interface and interaction with the user.
2. OCP :
   `Currency` interface: New currencies can be added by implementing this interface without modifying existing code.
   `CurrencyConverter` interface: Different conversion strategies can be implemented by creating new classes that implement this interface.
   `ExchangeRateProvider` interface: Different ways to provide exchange rates (e.g., from an API, database, etc.) can be added by implementing this interface.
3. LSP :
   Any class that implements the `Currency` interface (like `USDCurrency` or `INRCurrency`) can be used wherever a `Currency` type is expected.
   Any class that implements the `CurrencyConverter` interface (like `SimpleCurrencyConverter`) can be used wherever a `CurrencyConverter` type is expected.
   Any class that implements the `ExchangeRateProvider` interface (like `SimpleExchangeRateProvider`) can be used wherever an `ExchangeRateProvider` type is expected.
4. ISP :
   The `Currency`, `CurrencyConverter`, and `ExchangeRateProvider` interfaces are small and focused on specific functionalities. 
   This ensures that implementing classes only need to define methods they are concerned with, avoiding unnecessary dependencies.
5. DIP :
   The `SimpleCurrencyConverter` class depends on the `ExchangeRateProvider` interface rather than a concrete implementation. This allows different implementations of `ExchangeRateProvider` to be injected into `SimpleCurrencyConverter` without changing its code.
   The `CurrencyConverterCLI` class depends on the `CurrencyConverter` interface, allowing different conversion strategies to be used without modifying the CLI logic.

# Design Patterns
1. Factory Method : The CurrencyConverterCLI class uses a factory-like method to create instances of Currency:
   ```
    private Currency getCurrency(String code) {
        switch (code){
            case "USD": return new USDCurrency();
            case "INR": return new INRCurrency();
            default: return null;
        }
    }
   ```
2. Strategy Pattern : The CurrencyConverter interface and its implementation (SimpleCurrencyConverter) demonstrate the Strategy Pattern. Different conversion strategies can be implemented by creating new classes that implement the CurrencyConverter interface.
3. Dependency Injection : Dependency Injection is demonstrated in the constructor of the SimpleCurrencyConverter and CurrencyConverterCLI classes. Dependencies (ExchangeRateProvider and CurrencyConverter) are injected into the classes, promoting loose coupling and enhancing testability.
