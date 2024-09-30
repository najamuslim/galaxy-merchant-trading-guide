package com.galaxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {
    private final GalaxyInterpreter interpreter;
    private final TransactionManager transactionManager;

    public QueryProcessor(GalaxyInterpreter interpreter, TransactionManager transactionManager) {
        this.interpreter = interpreter;
        this.transactionManager = transactionManager;
    }

    public String processQuery(String query) {
        query = query.trim();
        if (query.matches("how much is .* \\?")) {
            return handleHowMuchQuery(query);
        } else if (query.matches("how many Credits is .* \\?")) {
            return handleHowManyCreditsQuery(query);
        } else {
            return "I have no idea what you are talking about";
        }
    }

    private String handleHowMuchQuery(String query) {
        Pattern pattern = Pattern.compile("how much is (.+) \\?");
        Matcher matcher = pattern.matcher(query);
        if (matcher.matches()) {
            String[] galaxyTerms = matcher.group(1).split(" ");
            int value = interpreter.convertGalaxyTermsToInteger(galaxyTerms);
            return String.join(" ", galaxyTerms) + " is " + value;
        }
        return "Invalid query format";
    }

    private String handleHowManyCreditsQuery(String query) {
        Pattern pattern = Pattern.compile("how many Credits is (.+) (\\w+) \\?");
        Matcher matcher = pattern.matcher(query);
        if (matcher.matches()) {
            String[] galaxyTerms = matcher.group(1).split(" ");
            String commodity = matcher.group(2);
            double totalCredits = transactionManager.calculateTotalCredits(galaxyTerms, commodity, interpreter);
            return String.join(" ", galaxyTerms) + " " + commodity + " is " + totalCredits + " Credits";
        }
        return "Invalid query format";
    }
}
