package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;
import java.security.SecureRandom;

public class Prime {

    private static final int MAX_RANDOM_NUMBER = 100;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void play(Scanner scanner) {
        String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            roundsData[i][0] = String.valueOf(number);
            roundsData[i][1] = isPrime(number) ? "yes" : "no";
        }

        Engine.run(description, roundsData, scanner);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
