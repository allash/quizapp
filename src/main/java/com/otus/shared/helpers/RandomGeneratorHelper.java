package com.otus.shared.helpers;

import java.util.Random;

public class RandomGeneratorHelper {

    public static int generateId(int min, int max) {
        Random rn = new Random();
        int range = max - min + 1;
        return rn.nextInt(range) + min;
    }

    public static int generateId() {
        return generateId(1, 100000);
    }
}
