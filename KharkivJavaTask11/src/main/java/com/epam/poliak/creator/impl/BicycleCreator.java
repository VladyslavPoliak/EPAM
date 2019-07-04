package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Writer;

public class BicycleCreator implements TransportCreator {

    private Writer writer;

    public BicycleCreator(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Bicycles create(InputHelper helper) {
        Bicycles bicycles = new Bicycles();
        fillTransport(bicycles, helper);
        writer.writeLine("WheelSize: ");
        bicycles.setWheelSize(helper.getInteger());
        writer.writeLine("NumberAbsorber: ");
        bicycles.setNumberAbsorber(helper.getInteger());
        return bicycles;
    }
}
