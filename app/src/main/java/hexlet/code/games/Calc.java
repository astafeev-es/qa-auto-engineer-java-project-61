package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;
import java.security.SecureRandom;

public class Calc {

    private static final int MAX_RANDOM_NUMBER = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void play(Scanner scanner) {
        String description = "What is the result of the expression?";
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            int num2 = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            String operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];

            roundsData[i][0] = num1 + " " + operator + " " + num2;
            roundsData[i][1] = String.valueOf(calculate(num1, num2, operator));
        }

        Engine.run(description, roundsData, scanner);
    }

    private static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }
}
