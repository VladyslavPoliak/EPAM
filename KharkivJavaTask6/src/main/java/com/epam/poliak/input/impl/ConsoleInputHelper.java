package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;

public class ConsoleInputHelper implements InputHelper {

    @Override
    public Integer getInteger(String ms) {
        System.out.println(ms);
        return scanner.nextInt();
    }

    @Override
    public String getString(String ms) {
        System.out.println(ms);
        return scanner.next();
    }
}
