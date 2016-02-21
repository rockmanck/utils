package ck.rockman.utils;

import java.util.Random;

public class Randoms {
    private static Random random = new Random();

    public static int sign() {
        final int i = random.nextInt(2);
        return i == 0 ? -1 : 1;
    }

    public static double realNumber() {
        final double v = random.nextDouble();
        final double result = sign() * v * 2500;
        return Math.round(result * 100) / 100.0;
    }

    public static Double[] arrayRealNumbers(int size) {
        final Double[] result = new Double[size];
        for (int i = 0; i < size; i += 1) {
            result[i] = realNumber();
        }
        return result;
    }
}