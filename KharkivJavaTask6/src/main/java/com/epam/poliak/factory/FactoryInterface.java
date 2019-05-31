package com.epam.poliak.factory;

import com.epam.poliak.entity.Transport;

import java.util.Random;
import java.util.Scanner;

public interface FactoryInterface {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    Transport create();

    default void randomFillCommonData(Transport transport) {
        transport.setProducer("Producer" + createRandomNumber(100, 2000));
        transport.setPrice(createRandomNumber(10000, 100000));
    }

    default void manualFillCommonData(Transport transport) {
        System.out.println("Enter producer");
        transport.setProducer(scanner.next());
        System.out.println("Enter price");
        transport.setPrice(scanner.nextInt());
    }

    default int createRandomNumber(int minNumber, int maxNumber) {
        int diffYear = maxNumber - minNumber;
        return random.nextInt(diffYear + 1) + minNumber;
    }

}
