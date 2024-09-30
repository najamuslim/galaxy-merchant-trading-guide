package com.galaxy;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GalaxyInterpreter interpreter = new GalaxyInterpreter();
        TransactionManager transactionManager = new TransactionManager();
        QueryProcessor queryProcessor = new QueryProcessor(interpreter, transactionManager);

        interpreter.addGalaxyMapping("glob", "I");
        interpreter.addGalaxyMapping("prok", "V");
        interpreter.addGalaxyMapping("pish", "X");
        interpreter.addGalaxyMapping("tegj", "L");

        transactionManager.addTransaction(new String[]{"glob", "glob"}, "Silver", 34, interpreter);
        transactionManager.addTransaction(new String[]{"glob", "prok"}, "Gold", 57800, interpreter);

        while (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            String result = queryProcessor.processQuery(query);
            System.out.println(result);
        }

        scanner.close();
    }
}
