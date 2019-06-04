package com.epam.poliak.input;

import java.util.*;

public class InputLocale {

    private Scanner scanner;
    private Map<String, Locale> inputTypes = new HashMap<>();

    public InputLocale() {
        scanner = new Scanner(System.in);
    }

    public Locale setLocale() {
        System.out.println("Choice locale" + System.lineSeparator()
                + "0 - English   1 - Russia  ");
        inputTypes.put("0", new Locale("en", "US"));
        inputTypes.put("1", new Locale("ru"));
        try {
            String type = scanner.nextLine();
            return inputTypes.get(type);
        } catch (InputMismatchException ex) {
            System.out.println("Incorrect data");
        }
        return inputTypes.get("0");
    }
}
