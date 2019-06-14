package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;
import com.epam.poliak.utils.Constants;
import com.epam.poliak.utils.ValidateUtils;

import java.util.InputMismatchException;

public class ConsoleInputHelper implements InputHelper {

    private Reader reader;
    private Writer writer;

    public ConsoleInputHelper(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public int getInteger() {
        String input;
        try {
            while (true) {
                input = reader.nextLine();
                if (ValidateUtils.validateEnter(input, Constants.NUMBERS)) {
                    return Integer.valueOf(input);
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            writer.writeLine("Try again!");
            return getInteger();
        }
    }

    @Override
    public String getString() {
        return reader.nextLine();
    }
}
