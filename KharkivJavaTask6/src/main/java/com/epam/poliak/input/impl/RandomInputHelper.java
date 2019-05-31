package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;

public class RandomInputHelper implements InputHelper {

    @Override
    public Integer getInteger(String ms) {
        return random.nextInt(500);
    }

    @Override
    public String getString(String ms) {
        return ms + random.nextInt(500);
    }

}
