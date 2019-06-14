package com.epam.poliak.input;

import com.epam.poliak.input.impl.ConsoleInputHelper;
import com.epam.poliak.input.impl.RandomInputHelper;
import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class InputStrategy {

    private Reader reader;
    private Writer writer;
    private Map<String, InputHelper> inputTypes = new HashMap<>();

    public InputStrategy(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public InputHelper setInputStrategy() {
        writer.writeLine("Choice input type" + System.lineSeparator()
                + "0 - MANUAL   1 - RANDOM  ");
        inputTypes.put("0", new ConsoleInputHelper(reader, writer));
        inputTypes.put("1", new RandomInputHelper());
        try {
            String type = reader.nextLine();
            return inputTypes.get(type);
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
        }
        writer.writeLine("Incorrect data entered. The default input method is selected");
        return inputTypes.get("1");
    }


}
