package com.galaxy;

import java.util.HashMap;
import java.util.Map;

import com.galaxy.RomanNumeralConverter;


public class GalaxyInterpreter {
    private final Map<String, String> galaxyToRomanMap = new HashMap<>();

    public void addGalaxyMapping(String galaxyTerm, String romanNumeral) {
        galaxyToRomanMap.put(galaxyTerm, romanNumeral);
    }

    public String convertGalaxyTermsToRoman(String[] galaxyTerms) {
        StringBuilder romanNumeral = new StringBuilder();
        for (String term : galaxyTerms) {
            romanNumeral.append(galaxyToRomanMap.get(term));
        }
        return romanNumeral.toString();
    }

    public int convertGalaxyTermsToInteger(String[] galaxyTerms) {
        StringBuilder romanNumerals = new StringBuilder();
        for (String term : galaxyTerms) {
            if (!galaxyToRomanMap.containsKey(term)) {
                throw new IllegalArgumentException("Unknown galaxy term: " + term);
            }
            romanNumerals.append(galaxyToRomanMap.get(term));
        }
        return RomanNumeralConverter.romanToDecimal(romanNumerals.toString());
    }

}
