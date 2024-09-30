package com.galaxy;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<Character, Integer> romanToIntegerMap = new HashMap<>();

    static {
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);
    }

    public static int romanToDecimal(String roman) {
        int total = 0;
        for (int i = 0; i < roman.length(); i++) {
            int current = romanToIntegerMap.get(roman.charAt(i));
            if (i + 1 < roman.length() && current < romanToIntegerMap.get(roman.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }
}
