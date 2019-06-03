package com.epam.poliak.input;

import com.epam.poliak.input.impl.ConsoleInputHelper;
import com.epam.poliak.input.impl.RandomInputHelper;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputStrategy {

    private Scanner scanner;
    private Map<String, InputHelper> inputTypes = new HashMap<>();

    public InputStrategy() {
        scanner = new Scanner(System.in);
    }

    public InputHelper setInputStrategy() {
        System.out.println("Choice input type" + System.lineSeparator()
                + "0 - MANUAL   1 - RANDOM  ");
        inputTypes.put("0", new ConsoleInputHelper());
        inputTypes.put("1", new RandomInputHelper());
        try {
            String type = scanner.nextLine();
            return inputTypes.get(type);
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
        }
        return inputTypes.get("1");
    }


}
