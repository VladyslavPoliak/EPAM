package com.epam.poliak.input;

import com.epam.poliak.factory.FactoryInterface;
import com.epam.poliak.factory.ManualFactory;
import com.epam.poliak.factory.RandomFactory;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputStrategy {

    private Scanner scanner;
    private Map<Integer, FactoryInterface> inputTypes = new HashMap<>();
    private String type = null;

    public InputStrategy() {
        scanner = new Scanner(System.in);
    }

    public FactoryInterface setInputStrategy() {
        System.out.println("Choice input type" + System.lineSeparator()
                + "0 - MANUAL   1 - RANDOM  ");
        inputTypes.put(0, new ManualFactory());
        inputTypes.put(1, new RandomFactory());
        try {
            type = scanner.nextLine();
            return inputTypes.get(Integer.parseInt(type));
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
        }
        return inputTypes.get(1);
    }


}
