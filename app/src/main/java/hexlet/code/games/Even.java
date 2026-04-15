package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;
import java.security.SecureRandom;

public class Even {

    private static final int MAX_RANDOM_NUMBER = 100;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void play(Scanner scanner) {
        String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = (number % 2 == 0) ? "yes" : "no";
        }

        Engine.run(description, roundsData, scanner);
    }
}
