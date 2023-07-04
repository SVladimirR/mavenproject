package org.example.computer;

import java.util.Random;

public class Computer {
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(3);
    }
}
