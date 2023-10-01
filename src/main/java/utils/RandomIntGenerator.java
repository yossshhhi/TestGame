package utils;

import java.util.Random;

public class RandomIntGenerator {
    private static final Random random = new Random();

    public static int generateRandomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Invalid range, min must be less than max");
        }
        return random.nextInt(max - min) + min;
    }
}
