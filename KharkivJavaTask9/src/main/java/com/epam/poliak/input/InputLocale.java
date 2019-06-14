package com.epam.poliak.input;

import com.epam.poliak.io.Reader;
import com.epam.poliak.io.Writer;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;

public class InputLocale {

    private Reader reader;
    private Writer writer;
    private Map<String, Locale> inputTypes = new HashMap<>();

    public InputLocale(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Locale setLocale() {
        writer.writeLine("Choice locale" + System.lineSeparator()
                + "0 - English   1 - Russia  ");
        inputTypes.put("0", new Locale("en", "US"));
        inputTypes.put("1", new Locale("ru"));
        try {
            String type = reader.nextLine();
            return inputTypes.get(type);
        } catch (InputMismatchException ex) {
            writer.writeLine("Incorrect data");
        }
        return inputTypes.get("0");
    }
}
