package com.galaxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GalaxyMerchantTradingGuideTest {

    @Test
    void testromanToDecimal() {
        assertEquals(1, RomanNumeralConverter.romanToDecimal("I"));
        assertEquals(5, RomanNumeralConverter.romanToDecimal("V"));
        assertEquals(9, RomanNumeralConverter.romanToDecimal("IX"));
    }

    @Test
    void testGalaxyInterpreter() {
        GalaxyInterpreter interpreter = new GalaxyInterpreter();
        interpreter.addGalaxyMapping("glob", "I");
        interpreter.addGalaxyMapping("prok", "V");

        assertEquals(4, interpreter.convertGalaxyTermsToInteger(new String[]{"glob", "prok"}));
    }

    @Test
    void testTransactionManager() {
        GalaxyInterpreter interpreter = new GalaxyInterpreter();
        interpreter.addGalaxyMapping("glob", "I");
        interpreter.addGalaxyMapping("prok", "V");

        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(new String[]{"glob", "glob"}, "Silver", 68, interpreter);

        assertEquals(68.0, transactionManager.calculateTotalCredits(new String[]{"glob", "glob"}, "Silver", interpreter));
    }

    @Test
    void testQueryProcessor() {
        GalaxyInterpreter interpreter = new GalaxyInterpreter();
        interpreter.addGalaxyMapping("glob", "I");
        interpreter.addGalaxyMapping("prok", "V");

        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(new String[]{"glob", "glob"}, "Silver", 68, interpreter);
        transactionManager.addTransaction(new String[]{"glob", "prok"}, "Gold", 28900, interpreter);

        QueryProcessor queryProcessor = new QueryProcessor(interpreter, transactionManager);

        assertEquals("glob prok is 4", queryProcessor.processQuery("how much is glob prok ?"));
        assertEquals("glob glob Silver is 68.0 Credits", queryProcessor.processQuery("how many Credits is glob glob Silver ?"));
        assertEquals("glob prok Gold is 28900.0 Credits", queryProcessor.processQuery("how many Credits is glob prok Gold ?"));
    }

}
