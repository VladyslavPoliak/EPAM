package com.epam.poliak.input.impl;

import com.epam.poliak.input.InputHelper;
import com.epam.poliak.utils.Utils;

public class RandomInputHelper implements InputHelper {

    @Override
    public int getInteger() {
        return random.nextInt(500);
    }

    @Override
    public String getString() {
        return Utils.randomWord(5, 10) + random.nextInt(500);
    }

}
