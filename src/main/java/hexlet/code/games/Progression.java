package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;
import java.util.Random;

public class Progression {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH_VARIANCE = 6; // 5 to 10
    private static final int MAX_START_VALUE = 20;
    private static final int MAX_STEP_VALUE = 10;

    public static void play(Scanner scanner) {
        String description = "What number is missing in the progression?";
        String[][] roundsData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int length = random.nextInt(MAX_LENGTH_VARIANCE) + MIN_LENGTH;
            int start = random.nextInt(MAX_START_VALUE);
            int step = random.nextInt(MAX_STEP_VALUE) + 1;
            int hiddenIndex = random.nextInt(length);

            String[] progression = makeProgression(start, step, length);

            roundsData[i][1] = progression[hiddenIndex];
            progression[hiddenIndex] = "..";
            roundsData[i][0] = String.join(" ", progression);
        }

        Engine.run(description, roundsData, scanner);
    }

    private static String[] makeProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}
