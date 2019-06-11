package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;

public class RandomInputHelper implements InputHelper {

    @Override
    public int getInteger() {
        return random.nextInt(500);
    }

    @Override
    public String getString() {
        return "Producer " + random.nextInt(500);
    }

}
