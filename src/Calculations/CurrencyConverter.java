package Calculations;

import Api.ApiConnection;

import java.util.Map;

public class CurrencyConverter {
    private final ApiConnection api = new ApiConnection();

    public double convert(int option, double amount) {
        ConversionRates rates = api.fetchRates("USD");
        Map<String, Double> conversions = rates.getConversion_rates();

        return switch (option) {
            case 1 -> amount * conversions.get("BRL"); // USD -> BRL
            case 2 -> amount / conversions.get("BRL"); // BRL -> USD
            case 3 -> amount * conversions.get("GBP"); // USD -> GBP
            case 4 -> amount / conversions.get("GBP"); // GBP -> USD
            case 5 -> amount * conversions.get("CLP"); // USD -> CLP
            case 6 -> amount / conversions.get("CLP"); // CLP -> USD
            default -> throw new IllegalArgumentException("Invalid conversion option.");
        };
    }
}
