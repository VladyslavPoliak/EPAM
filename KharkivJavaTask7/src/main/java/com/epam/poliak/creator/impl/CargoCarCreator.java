package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;

public class CargoCarCreator implements TransportCreator {

    @Override
    public Transport create(InputHelper helper) {
        CargoCar cargoCar = new CargoCar();
        fillCommonData(cargoCar, helper);
        cargoCar.setYearOfRelease(helper.getInteger("Year Of Release: "));
        cargoCar.setEnginePower(helper.getInteger("Engine Power: "));
        cargoCar.setNumberOfTrailers(helper.getInteger("Number Of Trailers: "));
        cargoCar.setMaxTransportWeight(helper.getInteger("Max Transport Weight: "));
        return cargoCar;
    }
}
