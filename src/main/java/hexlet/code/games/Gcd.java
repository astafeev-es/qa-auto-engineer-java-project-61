package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;
import java.util.Random;

public class Gcd {

    private static final int MAX_RANDOM_NUMBER = 100;
    private static final Random RANDOM = new Random();

    public static void play(Scanner scanner) {
        String description = "Find the greatest common divisor of given numbers.";
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
            int num2 = RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;

            roundsData[i][0] = num1 + " " + num2;
            roundsData[i][1] = String.valueOf(gcd(num1, num2));
        }

        Engine.run(description, roundsData, scanner);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
