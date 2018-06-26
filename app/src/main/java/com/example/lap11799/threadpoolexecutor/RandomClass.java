package com.example.lap11799.threadpoolexecutor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomClass{

    private static final String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length) {
        if (length < 0 || length > 10) {
            return "Random";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(36);
            stringBuilder.append(characters.charAt(index));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}