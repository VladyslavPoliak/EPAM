package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.input.InputHelper;

public class CargoCarCreator implements TransportCreator {

    @Override
    public CargoCar create(InputHelper helper) {
        CargoCar cargoCar = new CargoCar();
        fillCar(cargoCar, helper);
        System.out.println("Number Of Trailers: ");
        cargoCar.setNumberOfTrailers(helper.getInteger());
        System.out.println("Max Transport Weight: ");
        cargoCar.setMaxTransportWeight(helper.getInteger());
        return cargoCar;
    }
}
