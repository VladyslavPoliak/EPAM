package com.epam.poliak.factory;

import java.util.Random;

public interface FactoryInterface<T> {
     Random random = new Random();

    T create();

    default int createRandomNumber(int minNumber, int maxNumber) {
        int diffYear = maxNumber - minNumber;
        return random.nextInt(diffYear + 1) + minNumber;
    }

}
