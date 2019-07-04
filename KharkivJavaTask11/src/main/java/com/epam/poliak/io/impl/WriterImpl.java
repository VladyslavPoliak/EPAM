package com.epam.poliak.io.impl;

import com.epam.poliak.io.Writer;

public class WriterImpl implements Writer {

    @Override
    public void writeLine(Object item) {
        System.out.println(item);
    }
}
