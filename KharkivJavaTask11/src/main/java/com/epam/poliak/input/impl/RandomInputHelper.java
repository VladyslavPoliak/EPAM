package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;

import java.util.Random;

public class RandomInputHelper implements InputHelper {

    private Random random = new Random();

    @Override
    public int getInteger() {
        return random.nextInt(500);
    }

    @Override
    public String getString() {
        return "Producer " + random.nextInt(500);
    }

}
