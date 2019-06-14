package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Writer;

public class CargoCarCreator implements TransportCreator {

    private Writer writer;

    public CargoCarCreator(Writer writer) {
        this.writer = writer;
    }

    @Override
    public CargoCar create(InputHelper helper) {
        CargoCar cargoCar = new CargoCar();
        fillCar(cargoCar, helper);
        writer.writeLine("Number Of Trailers: ");
        cargoCar.setNumberOfTrailers(helper.getInteger());
        writer.writeLine("Max Transport Weight: ");
        cargoCar.setMaxTransportWeight(helper.getInteger());
        return cargoCar;
    }
}
