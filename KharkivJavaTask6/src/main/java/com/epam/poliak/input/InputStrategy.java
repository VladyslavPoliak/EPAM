package com.epam.poliak.input;

import com.epam.poliak.factory.Builder;
import com.epam.poliak.factory.ManualFactory;
import com.epam.poliak.factory.RandomFactory;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputStrategy {

    private Scanner scanner;
    private Map<String, Builder> inputTypes = new HashMap<>();

    public InputStrategy() {
        scanner = new Scanner(System.in);
    }

    public Builder setInputStrategy() {
        System.out.println("Choice input type" + System.lineSeparator()
                + "0 - MANUAL   1 - RANDOM  ");
        inputTypes.put("0", new ManualFactory());
        inputTypes.put("1", new RandomFactory());
        try {
            String type = scanner.nextLine();
            return inputTypes.get(type);
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
        }
        return inputTypes.get("1");
    }


}
