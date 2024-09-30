package com.galaxy;

import java.util.HashMap;
import java.util.Map;

public class TransactionManager {
    private final Map<String, Double> commodityPriceMap = new HashMap<>();

    public void addTransaction(String[] galaxyTerms, String commodity, double totalCredits, GalaxyInterpreter interpreter) {
        int quantity = interpreter.convertGalaxyTermsToInteger(galaxyTerms);
        if (quantity == 0) {
            throw new IllegalArgumentException("Quantity cannot be zero");
        }
        double unitPrice = totalCredits / quantity;
        commodityPriceMap.put(commodity, unitPrice);
    }

    public double calculateTotalCredits(String[] galaxyTerms, String commodity, GalaxyInterpreter interpreter) {
        int quantity = interpreter.convertGalaxyTermsToInteger(galaxyTerms);
        if (!commodityPriceMap.containsKey(commodity)) {
            throw new IllegalArgumentException("Commodity not found");
        }
        double unitPrice = commodityPriceMap.get(commodity);
        return quantity * unitPrice;
    }
}


