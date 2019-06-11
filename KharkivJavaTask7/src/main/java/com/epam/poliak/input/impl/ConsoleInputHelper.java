package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class ConsoleInputHelper implements InputHelper {

    @Override
    public int getInteger() {
        String input;
        try {
            while (true) {
                input = scanner.next();
                if (ValidateUtils.validateEnter(input, Constants.NUMBERS)) {
                    return Integer.valueOf(input);
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Try again!");
            return getInteger();
        }
    }

    @Override
    public String getString() {
        return scanner.next();
    }
}
